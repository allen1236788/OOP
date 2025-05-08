package CarCareCenter;

public class CarWash extends CarService {
    @Override
    public String getServiceName(){
        return "Car Wash";
    }
    @Override
    public double getServicePrice(){
        return 15.99;
    }
    @Override
    public void performService(){
        System.out.println("Performing a full exterior and interior wash.");
    }
    
}
