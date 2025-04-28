package casestudy.question2;

public class GuestCheckout extends  HotelService{
    public GuestCheckout(String guestId, String guestName, String roomType, int stayDays, String roomStatus) {
        super(guestId, guestName, roomType, stayDays, roomStatus);
    }

    @Override
    public void bookRoom() {

    }

    @Override
    public void checkoutGuest() {
        if(getRoomStatus().equalsIgnoreCase("OCCUPIED")){
            setRoomStatus("AVAILABLE");
            System.out.println("The guest " + getGuestName() + " (" + getGuestId() + ") has checked out successfully.");
        }else {
            System.out.println("Error: Room is available");
        }
    }

    @Override
    public void generateBill() {

    }
}
