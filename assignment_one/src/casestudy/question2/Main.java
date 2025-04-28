package casestudy.question2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== LEMIGO HOTEL SERVICES ===");
//        System.out.print("Enter guest ID: ");
        String id = validateId(scanner);
//        System.out.print("Enter guest name: ");
        String name = validateName(scanner);
//        System.out.print("Enter the room type(STANDARD/ DELUXE/ SUITE): ");
        String roomType = validateRoomType(scanner);
        String roomStatus = "AVAILABLE";
        System.out.println("=================================");
        System.out.println();
        int choice;
        do {
            System.out.println("Please choose your services");
            System.out.println("1. Room Booking");
            System.out.println("2. Guest Checkout");
            System.out.println("3. Billing");
            System.out.println("4. Exit");
//            System.out.print("Enter your choice: ");
            int stayDays = 0;
            choice = validateChoice(scanner);
            if (choice == 1 || choice == 3){
//                System.out.print("Enter the duration of your stay: ");
                stayDays = validateStayDays(scanner);
            }

            switch (choice){
                case 1:
                    RoomBooking booking = new RoomBooking(id, name, roomType, stayDays, roomStatus);
                    booking.bookRoom();
                    roomStatus = booking.getRoomStatus();
                    break;
                case 2:
                    GuestCheckout checkout = new GuestCheckout(id, name, roomType, stayDays, roomStatus);
                    checkout.checkoutGuest();
                    roomStatus = checkout.getRoomStatus();
                    break;
                case 3:
                    Billing billing = new Billing(id, name, roomType, stayDays, roomStatus);
                    billing.generateBill();
                    break;
                case 4:
                    System.out.println("Thank you for using our services!😁");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
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
    public static int validateStayDays(Scanner scanner){
        int value;
        while (true){
            System.out.print("Enter the duration of your stay: ");
            if (scanner.hasNextInt()){
                value = scanner.nextInt();
                if(value < 1 || value > 30){
                    System.out.println("Error: Invalid stay duration. Please enter a value between 1 and 30 days.");
                }else {
                    scanner.nextLine();
                    return value;
                }
            }else {
                System.out.println("Error: Please enter an integer value!");
                scanner.next();
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
    public static String validateId(Scanner scanner){
        String input;
        while (true){
            System.out.print("Enter the guest ID: ");
            input = scanner.nextLine().trim();
            if(input.matches("\\d+")){
                return input;
            }else {
                System.out.println("Error: The guest ID must only contain numbers! Try again.");
            }
        }
    }
    public static String validateRoomType(Scanner scanner){
        String input;
        while (true){
            System.out.print("Enter the room type(STANDARD/ DELUXE/ SUITE): ");
            input = scanner.nextLine().trim();
            if(input.equalsIgnoreCase("STANDARD") || input.equalsIgnoreCase("DELUXE") || input.equalsIgnoreCase("SUITE")){
                return input;
            }else {
                System.out.println("Error: Please enter the room types provided.");
            }
        }
    }
}
