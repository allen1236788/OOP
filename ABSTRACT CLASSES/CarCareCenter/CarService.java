package CarCareCenter;

public abstract class CarService{
    public void printServiceInfo(){
        System.out.println("Car Care Center!");
    }

    public abstract String getServiceName();
    public abstract double getServicePrice();
    public abstract void performService();
}