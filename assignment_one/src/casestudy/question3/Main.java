package casestudy.question3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String id = validateId(scanner);
        String name = validateName(scanner);
        String vehiclePlate = validateVehiclePlate(scanner);
        String violationType = validateViolationType(scanner);
        double fineAmount = 0;
        String paymentStatus = "UNPAID";
        int choice;

        do{
            System.out.println("==== TRAFFIC FINE MANAGEMENT SYSTEM ====");
            System.out.println("1. Violation Entry.");
            System.out.println("2. Fine Assessment.");
            System.out.println("3. Fine Payment.");
            System.out.println("4. Exit");

            choice = validateChoice(scanner);

            switch (choice){
                case 1:
                    ViolationEntry violationEntry = new ViolationEntry(id,name,vehiclePlate,violationType,fineAmount,paymentStatus);
                    violationEntry.recordViolation();
                    paymentStatus = violationEntry.getPaymentStatus();
                    break;
                case 2:
                    FineAssessment assessment = new FineAssessment(id,name,vehiclePlate,violationType,fineAmount,paymentStatus);
                    assessment.assessFine();
                    break;
                case 3:
                    FinePayment payment = new FinePayment(id,name,vehiclePlate,violationType,fineAmount,paymentStatus);
                    payment.processPayment();
                    paymentStatus = payment.getPaymentStatus();
                    break;
                case 4:
                    System.out.println("Thanks for using our services!😁");
                    break;
                default:
                    System.out.println("Error: Invalid Choice! Please Try again.");
                    break;
            }

        }while (choice != 4);
    }
    public static int validateChoice(Scanner scanner){
        int value;
        while (true){
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()){
                value = scanner.nextInt();
                scanner.nextLine();
                return value;
            }else {
                System.out.println("Error: Please enter an integer value!");
                scanner.next();
            }
        }
    }
    public static String validateId(Scanner scanner){
        String input;
        while (true){
            System.out.print("Enter the driver ID: ");
            input = scanner.nextLine().trim();
            if(input.matches("\\d{16}")){
                return input;
            }else {
                System.out.println("Error: The driver ID contain 16 numbers! Try again.");
            }
        }
    }
    public static String validateName(Scanner scanner){
        String input;
        while (true){
            System.out.print("Enter the guest Name: ");
            input = scanner.nextLine().trim();
            if(input.matches("[a-zA-Z ]+")){
                return input;
            }else {
                System.out.println("Error: The name must only contain letters! Try again.");
            }
        }
    }
    public static String validateVehiclePlate(Scanner scanner){
        String input;
        while (true){
            System.out.print("Enter the vehicle plate: ");
            input = scanner.nextLine().trim();
            if(input.matches("R[A-Z]{2}\\d{3}[A-Z]")){
                return input;
            }else {
                System.out.println("Error: Invalid plate format (e.g RAB123D).");
            }
        }
    }
    public static String validateViolationType(Scanner scanner){
        String input;
        while (true){
            System.out.print("Enter the violation type(SPEEDING/ RED_LIGHT/ NO_HELMET/ DUI): ");
            input = scanner.nextLine().trim();
            if(input.equalsIgnoreCase("SPEEDING") ||
                    input.equalsIgnoreCase("RED_LIGHT") ||
                    input.equalsIgnoreCase("NO_HELMET") ||
                    input.equalsIgnoreCase("DUI"))
            {
                return input;
            }else {
                System.out.println("Error: Unknown violation type.");
            }
        }
    }
}
