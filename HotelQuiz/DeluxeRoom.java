public class DeluxeRoom extends HotelRoom {

    public DeluxeRoom(String roomNumber, double ratePerNight, boolean isAvailable) {
        super("Deluxe", ratePerNight);
        this.roomNumber = roomNumber;
        this.isAvailable = isAvailable;
    }

    @Override
    public double calculatePrice(int nights, boolean isMember) {
        double total = ratePerNight * nights;

        if (nights >= 3) {
            if (isMember) {
                total *= 0.85;  
            } else {
                total *= 0.90;  
            }
        } else {
            if (isMember) {
                total *= 0.95;  
            }
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

