package casestudy.question3;

public class ViolationEntry extends TrafficRecord {
    public ViolationEntry(String driverId, String driverName, String vehiclePlate, String violationType, double fineAmount, String paymentStatus) {
        super(driverId, driverName, vehiclePlate, violationType, fineAmount, paymentStatus);
    }

    @Override
    public void recordViolation() {
        if(!getViolationType().equalsIgnoreCase("SPEEDING") &&
                !getViolationType().equalsIgnoreCase("RED_LIGHT") &&
                !getViolationType().equalsIgnoreCase("NO_HELMET") &&
                !getViolationType().equalsIgnoreCase("DUI")
        ){
            System.out.println("Invalid violation type.");
            return;
        }
        setPaymentStatus("UNPAID");
        System.out.println("Violation Recorded:");
        System.out.println("Driver: "+getDriverName()+" | ID: "+getDriverId());
        System.out.println("Plate: "+ getVehiclePlate()+" | Violation: "+getViolationType());
        System.out.println("Status: "+getPaymentStatus());
    }

    @Override
    public void assessFine() {

    }

    @Override
    public void processPayment() {

    }
}
