package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.PaymentFactory;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PaymentRepositoryTest {
    private static PaymentRepository repository = PaymentRepository.getRepository();
    private static Payment payment = PaymentFactory.createPayment("PAY-100", 500.00, LocalDate.now(), "Cash");

    @Test
    @Order(1)
    void create() {
        Payment created = repository.create(payment);
        assertNotNull(created);
        System.out.println("Created: " + created);
    }

    @Test
    @Order(2)
    void read() {
        Payment read = repository.read(payment.getPaymentId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    @Order(3)
    void update() {
        Payment updated = new Payment.Builder().copy(payment).setAmount(750.00).build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println("Show All: " + repository.getAll());
    }

    @Test
    @Order(5)
    void delete() {
        boolean success = repository.delete(payment.getPaymentId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }
}
