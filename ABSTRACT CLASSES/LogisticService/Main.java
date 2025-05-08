package LogisticService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        DeliveryService[] deliveries= new DeliveryService[3];

        for (int i=0; i< deliveries.length; i++){
            System.out.println("\nEnter details for delivery #" + (i + 1));
            System.out.println("Enter distance (km): ");
            double distance=scanner.nextDouble();

            System.out.println("Enter weight (kg): ");
            double weight=scanner.nextDouble();

            System.out.println("Select service type(1 - Standard, 2 - Express): ");
            int choice=scanner.nextInt();

            if(choice==1){
                deliveries[i]= new StandardDelivery(distance, weight);
            }else if(choice==2){
                deliveries[i]=new ExpressDelivery(distance, weight);
            }else{
                System.out.println("Invalid choice. Defaulting to Standard.");
                deliveries[i]=new StandardDelivery(distance, weight);
            }
        }

        System.out.println("\n---Delivery Summary ---");
        for (DeliveryService delivery : deliveries){
            System.out.println("\nService type: "+ delivery.getServiceType());
            delivery.printBasicInfo();
            double cost = delivery.calculateCost();
            System.out.println("Total Cost: "+ cost);
        }
        scanner.close();
    }
}
