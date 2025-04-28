package casestudy.question3;

public class FinePayment extends TrafficRecord{
    public FinePayment(String driverId, String driverName, String vehiclePlate, String violationType, double fineAmount, String paymentStatus) {
        super(driverId, driverName, vehiclePlate, violationType, fineAmount, paymentStatus);
    }

    @Override
    public void recordViolation() {

    }

    @Override
    public void assessFine() {

    }

    @Override
    public void processPayment() {
        if (getPaymentStatus().equalsIgnoreCase("PAID")){
            System.out.println("Payment already completed.");
            return;
        }
        setPaymentStatus("PAID");
        System.out.println("Payment Successful:");
        System.out.println("Driver: "+getDriverName());
        System.out.println("Plate: "+getVehiclePlate());
        System.out.println("Amount Paid: "+getFineAmount());
        System.out.println("Payment Status: "+getPaymentStatus());
    }
}