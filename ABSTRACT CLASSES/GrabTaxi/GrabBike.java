package GrabTaxi;

public class GrabBike extends GrabRide {
    public GrabBike(String pickup, String dropOff, double distance){
        super(pickup,dropOff,distance,15.0);//Base fare for bike
    }
    
    @Override
    public double calculateFare(){
        return baseFare+(6.0 *distance);//base fare +6 per km
    }

    @Override
    public String getRideType(){
        return "GrabBike";
    }

    @Override
    public int estimateArrivalTime(){
        return (int)(3+distance);//slighty faster due to bike
    }
}
