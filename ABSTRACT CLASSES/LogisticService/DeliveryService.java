package LogisticService;

public abstract class DeliveryService {
    protected double distance;
    protected double weight;

    public DeliveryService(double distance, double weight){
        this.distance=distance;
        this.weight=weight;
    }

    public void printBasicInfo(){
        System.out.println("Distance: "+ distance + " km");
        System.out.println("Weigth: "+ weight + " kg");
    }

    public abstract String getServiceType();
    public abstract double calculateCost(); 
}
