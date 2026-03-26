package za.ac.cput.domain;
import java.time.LocalDate;

public class Payment {
    private final String paymentId;
    private final double amount;
    private final LocalDate paymentDate;
    private final String paymentMethod;
    private Payment(Builder builder) {
        this.paymentId = builder.paymentId;
        this.amount = builder.amount;
        this.paymentDate = builder.paymentDate;
        this.paymentMethod = builder.paymentMethod;
    }

    public String getPaymentId() { return paymentId; }
    public double getAmount() { return amount; }
    public LocalDate getPaymentDate() { return paymentDate; }
    public String getPaymentMethod() { return paymentMethod; }

    public static class Builder {
        private String paymentId;
        private double amount;
        private LocalDate paymentDate;
        private String paymentMethod;

        public Builder setPaymentId(String paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setPaymentDate(LocalDate paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public Builder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder copy(Payment payment) {
            this.paymentId = payment.paymentId;
            this.amount = payment.amount;
            this.paymentDate = payment.paymentDate;
            this.paymentMethod = payment.paymentMethod;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
