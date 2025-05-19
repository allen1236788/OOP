public abstract class HotelRoom {
 
    protected String roomNumber;
    protected String roomType;
    protected double ratePerNight;
    protected boolean isAvailable;
    protected boolean isnotAvailable;

    protected static HotelRoom[] rooms = new HotelRoom[6];

    static {
        rooms[0] = new DeluxeRoom("101", 1500.0, true);  
        rooms[1] = new DeluxeRoom("102", 1200.0, true);  
        rooms[2] = new StandardRoom("201", 1000.0, true); 
        rooms[3] = new StandardRoom("202", 1100.0, true); 
        rooms[4] = new SuiteRoom("301", 2500.0, true);    
        rooms[5] = new SuiteRoom("302", 2700.0, true);    
    }

    public HotelRoom(String roomType, double ratePerNight) {
        this.roomType = roomType;
        this.ratePerNight = ratePerNight;
    }
    

    public abstract double calculatePrice(int nights, boolean isMember);
    public boolean checkRoomAvailability(int roomIndex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkRoomAvailability'");
    }
    public abstract void bookRoom(int roomIndex);

   @Override 
    public String toString() {
        return "Room " + roomNumber + " | Type: " + roomType + " | Rate: " + ratePerNight + "/night";
    }

}