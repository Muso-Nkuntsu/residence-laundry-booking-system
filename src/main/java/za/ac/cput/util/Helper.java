package za.ac.cput.util;
import java.util.regex.Pattern;


public class Helper {
    public static boolean isNullOrEmpty(String s){
        return s == null || s.isEmpty() || s.isBlank();
    }
    public static boolean isValidEmail(String email){
        if (isNullOrEmpty(email)) return false;
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.compile(emailRegex).matcher(email).matches();
    }
    public static boolean isValid(String id){
        return !isNullOrEmpty(id);
    }
}
