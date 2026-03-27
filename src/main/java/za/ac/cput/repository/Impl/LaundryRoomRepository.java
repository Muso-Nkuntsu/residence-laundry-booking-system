/*
 * Name:Sabotseng Ndaba
 *Student Nr: 230235875
 * Date: 23 March 2026  */



package za.ac.cput.repository.Impl;

import za.ac.cput.domain.LaundryRoom;
import za.ac.cput.repository.ILaundryRoomRepository;

import java.util.HashSet;
import java.util.Set;


public class LaundryRoomRepository implements ILaundryRoomRepository {

    private static LaundryRoomRepository repository = null;
    private Set<LaundryRoom> laundryRooms;

    private LaundryRoomRepository(){
        laundryRooms = new HashSet<>();
    }

    public static LaundryRoomRepository getRepository(){
        if( repository == null){
            repository = new LaundryRoomRepository();
        }
        return repository;
    }
    @Override
    public LaundryRoom create(LaundryRoom laundryRoom){
        laundryRooms.add(laundryRoom);
        return laundryRoom;
    }

    @Override
    public LaundryRoom read(String roomId){
        return laundryRooms.stream()
                .filter(r -> r.getRoomId().equals(roomId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public LaundryRoom update(LaundryRoom laundryRoom){
        LaundryRoom existing = read(laundryRoom.getRoomId());
        if(existing != null){
            laundryRooms.remove(existing);
            laundryRooms.add(laundryRoom);
            return laundryRoom;
        }
        return null;
    }

    @Override
    public boolean delete(String roomId){
        LaundryRoom existing = read(roomId);
        if(existing != null){
            laundryRooms.remove(existing);
            return true;
        }
        return false;
    }

    @Override
    public Set<LaundryRoom> getAll(){
        return laundryRooms;
    }



}
