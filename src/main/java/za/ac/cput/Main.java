package za.ac.cput;

<<<<<<< HEAD
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
=======
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
>>>>>>> 9143d0333aab82dedf6bd4a52dc1196e1dd44426
    }
}