package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Payment;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class PaymentFactoryTest {

    @Test
    void testCreatePayment() {
        Payment payment = PaymentFactory.createPayment("230541844-P1", 500.00, LocalDate.now(), "EFT");
        assertNotNull(payment);
        System.out.println("Payment Created: " + payment.toString());
    }

    @Test
    void testCreatePaymentWithInvalidAmount() {
        Payment payment = PaymentFactory.createPayment("230541844-P2", 0, LocalDate.now(), "Cash");
        assertNull(payment);
        System.out.println("Validation passed: Payment is null for 0 amount.");
    }
}
