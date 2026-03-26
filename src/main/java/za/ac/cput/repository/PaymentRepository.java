package za.ac.cput.repository;

import za.ac.cput.domain.Payment;
import java.util.HashSet;
import java.util.Set;

public class PaymentRepository implements IPaymentRepository {
    private static PaymentRepository repository = null;
    private Set<Payment> paymentDB;

    private PaymentRepository() {
        paymentDB = new HashSet<>();
    }

    public static PaymentRepository getRepository() {
        if (repository == null) {
            repository = new PaymentRepository();
        }
        return repository;
    }

    @Override
    public Payment create(Payment payment) {
        boolean success = paymentDB.add(payment);
        if (!success) return null;
        return payment;
    }

    @Override
    public Payment read(String paymentId) {
        for (Payment p : paymentDB) {
            if (p.getPaymentId().equals(paymentId)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public Payment update(Payment payment) {
        Payment oldPayment = read(payment.getPaymentId());
        if (oldPayment != null) {
            paymentDB.remove(oldPayment);
            paymentDB.add(payment);
            return payment;
        }
        return null;
    }

    @Override
    public boolean delete(String paymentId) {
        Payment paymentToDelete = read(paymentId);
        if (paymentToDelete == null) return false;
        paymentDB.remove(paymentToDelete);
        return true;
    }

    @Override
    public Set<Payment> getAll() {
        return paymentDB;
    }
}
