package CarCareCenter;

public class Main {
    public static void main(String[] args) {
        CarService wash=new CarWash();
        CarService oil=new OilChange();

        wash.printServiceInfo();
        System.out.println("Sevice: "+wash.getServiceName());
        System.out.println("Price: "+wash.getServicePrice());
        wash.performService();

        System.out.println("\n-----------------------\n");

        oil.printServiceInfo();
        System.out.println("Service: "+ oil.getServiceName());
        System.out.println("Price: "+oil.getServicePrice());
        oil.performService();
    }
}
