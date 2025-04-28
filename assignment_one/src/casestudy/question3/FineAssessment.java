package casestudy.question3;

import java.security.spec.RSAOtherPrimeInfo;

public class FineAssessment extends TrafficRecord{
    public FineAssessment(String driverId, String driverName, String vehiclePlate, String violationType, double fineAmount, String paymentStatus) {
        super(driverId, driverName, vehiclePlate, violationType, fineAmount, paymentStatus);
    }

    @Override
    public void recordViolation() {

    }

    @Override
    public void assessFine() {
        switch (getViolationType().toUpperCase()){
            case "SPEEDING": setFineAmount(50_000);break;
            case "RED_LIGHT": setFineAmount(80_000);break;
            case "NO_HELMET": setFineAmount(30_000);break;
            case "DUI": setFineAmount(150_000);break;
            default:
                System.out.println("Unknown violation type!");
                return;
        }
        System.out.println("Fine Assessment:");
        System.out.println("Driver: "+getDriverName()+" | Violation: "+getViolationType());
        System.out.println("Fine Amount: "+getFineAmount()+" RWF");
    }

    @Override
    public void processPayment() {

    }
}