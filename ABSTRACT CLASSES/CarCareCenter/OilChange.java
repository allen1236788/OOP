package CarCareCenter;

public class OilChange extends CarService {
     @Override
     public String getServiceName(){
        return "Oil Change";
     }
     @Override
     public double getServicePrice(){
       return 49.99;
     }
     @Override
     public void performService(){
        System.out.println("Changing emgine oil and replacing oil filter.");
     }
}
