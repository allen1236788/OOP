package LogisticService;

public class StandardDelivery extends DeliveryService{
    public StandardDelivery (double distance,double weight){
        super(distance, weight);
    }
    
    @Override
    public String getServiceType(){
        return "Standard Delivery";
    }

    @Override
    public double calculateCost(){
        double costPerKg=5.0;
        return costPerKg * weight +(0.5 * distance);
    }
}
