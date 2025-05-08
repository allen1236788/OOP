package GrabTaxi;

public class GrabCar extends GrabRide {
    public GrabCar(String pickup,String dropOff, double distance){
        super(pickup, dropOff, distance, 25.0);//Base fare for car
    }
    
    @Override
    public double calculateFare(){
        return baseFare + (10.0*distance); // base fare + 10 per km
    }

    @Override
    public String getRideType(){
        return "GrabCar";
    }

    @Override
    public int estimateArrivalTime(){
        return (int)(5+distance*1.5);//baic estimation
    }
}
