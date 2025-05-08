package LogisticService;

public class ExpressDelivery extends DeliveryService {
    public ExpressDelivery(double distance, double weight){
        super(distance, weight);
    }

    @Override
    public String getServiceType(){
        return "Express Delivery";
    }

    @Override
    public double calculateCost(){
        double costPerKg=8.0;
        double baseCost= costPerKg * weight + (0.8 * distance);

        //Apply surcharge for long distances
        if(distance> 500){
            baseCost+=50;//Flat surcharge
        }

        return baseCost;
    }
}
