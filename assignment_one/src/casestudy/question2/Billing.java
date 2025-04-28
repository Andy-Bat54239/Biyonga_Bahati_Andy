package casestudy.question2;

public class Billing extends HotelService{
    public Billing(String guestId, String guestName, String roomType, int stayDays, String roomStatus) {
        super(guestId, guestName, roomType, stayDays, roomStatus);
    }

    @Override
    public void bookRoom() {

    }

    @Override
    public void checkoutGuest() {


    }

    @Override
    public void generateBill() {
        double rate = 0;
        if(getStayDays() < 1 || getStayDays() > 30){
            System.out.println("Invalid stay duration. Please enter a value between 1 and 30 days.");
            return;
        }
        switch (getRoomType().toUpperCase()){
            case "STANDARD": rate = 50_000;break;
            case "DELUXE": rate = 80_000;break;
            case "SUITE": rate = 120_000;break;
            default:
                System.out.println("Invalid room type");
                return;
        }
        double total = rate * getStayDays();

        System.out.println("=== BILL SUMMARY ===");
        System.out.println("Guest Name: "+getGuestName());
        System.out.println("Guest ID: "+getGuestId());
        System.out.println("Room Type: "+getRoomType());
        System.out.println("Days stayed: "+getStayDays());
        System.out.printf("Total Cost: %, .2f RWF%n", total);
    }
}
