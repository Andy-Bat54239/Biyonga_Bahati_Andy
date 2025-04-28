package casestudy.question2;

public class RoomBooking extends HotelService{
    public RoomBooking(String guestId, String guestName, String roomType, int stayDays, String roomStatus) {
        super(guestId, guestName, roomType, stayDays, roomStatus);
    }

    @Override
    public void bookRoom() {
        if(getStayDays() < 1 || getStayDays() > 30){
            System.out.println("Invalid stay duration. Please enter a value between 1 and 30 days.");
            return;
        }
        if(getRoomStatus().equalsIgnoreCase("AVAILABLE")){
            setRoomStatus("OCCUPIED");
            System.out.println("Room booked successfully for " +getGuestName() + " (" + getGuestId() + ").");
        } else {
            System.out.println("Error: Room is not available.");
        }
    }


    @Override
    public void checkoutGuest() {

    }

    @Override
    public void generateBill() {

    }
}
