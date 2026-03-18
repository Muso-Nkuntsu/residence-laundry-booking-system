package za.ac.cput;

import za.ac.cput.domain.Payment;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Payment payment = new Payment.Builder()
                .setPaymentId("PAY-1001")
                .setAmount(250.00)
                .setPaymentDate(LocalDate.now())
                .setPaymentMethod("Credit Card")
                .build();

        System.out.println(payment);
    }
}