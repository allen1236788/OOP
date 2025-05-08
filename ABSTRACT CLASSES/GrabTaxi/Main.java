package GrabTaxi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Welcome to Grab!");
        System.out.print("Enter pickup location: ");
        String pickup=scanner.nextLine();

        System.out.print("Enter drop-off location: ");
        String dropoff=scanner.nextLine();

        System.out.print("Enter distance (in km): ");
        double distance=scanner.nextDouble();

        System.out.print("Choose ride type(1 - GrabCar, 2 - GrabBike): ");
        int choice=scanner.nextInt();

        GrabRide ride;

        if(choice==1){
            ride=new GrabCar(pickup, dropoff, distance);
        }else{
            ride=new GrabBike(pickup, dropoff, distance);
        }

        System.out.println("\n---booking Summary ---");
        System.out.println("Ride Type: "+ ride.getRideType());
        ride.showRoute();
        System.out.println("Estimated Arrival: "+ride.estimateArrivalTime() + "minutes");
        System.out.println("Estimated Fare: "+ ride.calculateFare());

        scanner.close();
    }
}
