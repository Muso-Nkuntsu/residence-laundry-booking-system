package za.ac.cput.domain;

public class LaundryMachine {
    protected String machineId;
    protected int machineNumber;
    protected String status;

<<<<<<< HEAD
=======

>>>>>>> 24089b37da33d92fd10ebf69c2d53afa19fcecc6
    private LaundryMachine(Builder builder) {
        this.machineId = builder.machineId;
        this.machineNumber = builder.machineNumber;
        this.status = builder.status;
    }

<<<<<<< HEAD
    public String getMachineId() {
        return machineId;
    }

    public int getMachineNumber() {
        return machineNumber;
    }

    public String getStatus() {
        return status;
    }

=======
>>>>>>> 24089b37da33d92fd10ebf69c2d53afa19fcecc6
    @Override
    public String toString() {
        return "LaundryMachine{" +
                "machineId='" + machineId + '\'' +
                ", machineNumber=" + machineNumber +
                ", status='" + status + '\'' +
                '}';
    }

    public static class Builder {
        private String machineId;
        private int machineNumber;
        private String status;

        public Builder setMachineId(String machineId) {
            this.machineId = machineId;
            return this;
        }

        public Builder setMachineNumber(int machineNumber) {
            this.machineNumber = machineNumber;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public LaundryMachine build() {
            return new LaundryMachine(this);
        }
    }
<<<<<<< HEAD
}
=======
}

>>>>>>> 24089b37da33d92fd10ebf69c2d53afa19fcecc6
