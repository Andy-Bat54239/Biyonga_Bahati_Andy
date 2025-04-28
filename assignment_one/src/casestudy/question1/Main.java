package casestudy.question1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        System.out.print("Enter contractor ID: ");
        String id = validateId(scanner);

//        System.out.print("Enter contractor Name: ");
        String name = validateName(scanner);

        double initialBalance = validateDouble(scanner, "Enter initial material balance (tons): ");

        int choice;
        do {
            System.out.println("=== Site Construction Management System ===");
            System.out.println("1. Material Delivery.");
            System.out.println("2. Material Usage.");
            System.out.println("3. Cost Estimation");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = validateInt(scanner);

            double quantity = 0;
            if (choice < 4){
                quantity = validateDouble(scanner, "Enter Material Quantity (tons): ");
            }



            switch (choice){
                case 1:
                    MaterialDelivery delivery = new MaterialDelivery(id, name, quantity, initialBalance);
                    delivery.receiveMaterial();
                    initialBalance = delivery.getMaterialBalance();
                    break;
                case 2:
                    MaterialUsage usage = new MaterialUsage(id, name, quantity, initialBalance);
                    usage.useMaterial();
                    initialBalance = usage.getMaterialBalance();
                    break;
                case 3:
                    CostEstimation costEstimation = new CostEstimation(id, name, quantity, initialBalance);
                    costEstimation.estimateCost();
                    break;
                case 4:
                    System.out.println("Thank you for using our system!😁");
                    break;
                default:
                    System.out.println("Invalid Choice! Please try again.");
            }

        } while (choice != 4);
    }

    private static double validateDouble(Scanner scanner, String message){
        double value;
        while (true){
            System.out.print(message);
            if (scanner.hasNextDouble()){
                value = scanner.nextDouble();
                scanner.nextLine();
                return value;
            }else {
                System.out.println("Error: Please enter a valid number");
                scanner.next();
            }
        }
    }
    private static int validateInt(Scanner scanner){
        int value;
        while (true){
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()){
                value = scanner.nextInt();
                scanner.nextLine();
                return value;
            }else {
                System.out.println("Error: Please enter a valid number");
                scanner.next();
            }
        }
    }
    private static String validateId(Scanner scanner){
        String input;
        while (true){
            System.out.print("Enter contractor ID: ");
            input = scanner.nextLine().trim();
            if(input.matches("\\d+")){
                return input;
            }else {
                System.out.println("Error: Please enter a valid ID.");
            }
        }
    }
    private static String validateName(Scanner scanner){
        String name;
        while (true){
            System.out.print("Enter contractor name: ");
            name = scanner.nextLine().trim();
            if(name.matches("[a-zA-Z ]+")){
                return name;
            }else {
                System.out.println("Error: Input must contain only letters. Try again.");
            }
        }
    }
}
