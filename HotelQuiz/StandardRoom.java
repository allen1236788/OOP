public class StandardRoom extends HotelRoom {

    public StandardRoom(String roomNumber, double ratePerNight, boolean isAvailable) {
        super("Standard", ratePerNight);
        this.roomNumber = roomNumber;
        this.isAvailable = isAvailable;
    }

    @Override
    public double calculatePrice(int nights, boolean isMember) {
        double total = ratePerNight * nights;

        if (isMember) {
            total *= 0.95;
        }

        return total;
    }

    @Override
    public boolean checkRoomAvailability(int roomIndex) {
        if (roomIndex >= 0 && roomIndex < rooms.length) {
            return rooms[roomIndex].isAvailable;
        }
        return false;
    }

    @Override
    public void bookRoom(int roomIndex) {
        if (roomIndex >= 0 && roomIndex < rooms.length && rooms[roomIndex].isAvailable) {
            rooms[roomIndex].isAvailable = false;
            System.out.println("Room " + rooms[roomIndex].roomNumber + " successfully booked!");
        } else {
            System.out.println("Room not available.");
        }

    }
}

