import domain.Payment;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Using the Builder to create a Payment object
        Payment payment = new Payment.Builder()
                .setPaymentId("PAY-1001")
                .setAmount(250.00)
                .setPaymentDate(LocalDate.now())
                .setPaymentMethod("Credit Card")
                .build();

        System.out.println(payment);
    }
}