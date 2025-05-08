package GrabTaxi;

public abstract class GrabRide {
    protected String pickupLocation;
    protected String dropoffLocation;
    protected double distance;
    protected double baseFare;

    public GrabRide(String pickupLocation, String dropoffLocation, double distance, double baseFare){
        this.pickupLocation=pickupLocation;
        this.dropoffLocation=dropoffLocation;
        this.distance=distance;
        this.baseFare=baseFare;
    }
    public void showRoute(){
        System.out.println("From: "+ pickupLocation + " To: "+ dropoffLocation);
    }
    public abstract double calculateFare();
    public abstract String getRideType();
    public abstract int estimateArrivalTime();//in minutes
}
