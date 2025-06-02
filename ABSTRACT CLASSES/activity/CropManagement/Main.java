package CropManagement;
import java.util.Scanner;
public class Main {
 

    int[] crops = new int[Crops.seeds.length]; 
public static void main(String[] args) {
       Scanner scanner=new Scanner(System.in);
    databaseManager dbManager = new databaseManager(); 

   while (true) {
 
            System.out.println("\n--- Crop Menu ---\n");
            System.out.println("1. Check Quantity");
            System.out.println("2. Buy Crops");
            System.out.println("3. Buy Fertilizers");
            System.out.println("4. Pest Control");
            System.out.println("5. Labor payment");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");
        
            int choice = scanner.nextInt();
                   scanner.nextLine();
            if((choice<1)&& choice>6){
            System.out.println("choose only from 1-6");
        }else
    

        if(choice == 1){
            System.out.println("\n--- Check Quantity ---\n");
            displaycrops();
            
        }

        else if(choice == 2){
            System.out.println("\n--- Buy Crops ---\n");
            System.out.println("Enter crop to buy: ");
            int cropSeed=scanner.nextInt();
            System.out.println("Enter Quantity to add: ");
            int q=scanner.nextInt();
            scanner.nextLine();

            if(cropSeed==1){
                
                int cropQuantity=100+q;
                boolean Quantity=dbManager.updateQuantity(cropSeed,cropQuantity);
                if(Quantity){
                    System.out.println("Quantity added!");
                }else{
                    System.out.println("Failed!");
                }
            }else if(cropSeed==2){
                int cropQuantity=100+q;
                boolean Quantity=dbManager.editPass(cropSeed,cropQuantity);
                if(Quantity){
                    System.out.println("Quantity added!");
                }else{
                    System.out.println("Failed!");
                }
            }else if (cropSeed==3){
                int cropQuantity=100+q;
                boolean Quantity=dbManager.updateQuantity(cropSeed,cropQuantity);
                if(Quantity){
                    System.out.println("Quantity added!");
                }else{
                    System.out.println("Failed!");
                }
            }else if(cropSeed==4){
                int cropQuantity=100+q;
                boolean Quantity=dbManager.updateQuantity(cropSeed,cropQuantity);
                if(Quantity){
                    System.out.println("Quantity added!");
                }else{
                    System.out.println("Failed!");
                }
            }
            
        }

        else if(choice == 3){
            System.out.println("\n--- Buy Fertilizers ---\n");
            
            
        }

        else if(choice == 4){
            System.out.println("\n---  Pest Control ---\n");
            System.out.println("1. Buy BPMC+CHLORPYRIFOS");
            System.out.println("2. Buy CYPERMETHRIN");
            System.out.println("3. Buy LAMBDACYHALOTHRIN");
            System.out.print("Select an option: ");
            int pestChoice = scanner.nextInt();
            scanner.nextLine();
            if(pestChoice == 1){
                System.out.println("You have selected BPMC+CHLORPYRIFOS");
                System.out.println("Price: 552.50 per liter");
            }
            else if(pestChoice == 2){
                System.out.println("You have selected CYPERMETHRIN");
                System.out.println("Price: 447.50 per liter");
            }
            else if(pestChoice == 3){
                System.out.println("You have selected LAMBDACYHALOTHRIN");
                System.out.println("Price: 632.50 per liter");
            }
            else{
                System.out.println("Invalid option selected.");
            }
            
        }

        else if(choice == 5){
            System.out.println("\n--- Labor payment ---\n");
            
            
        }

        else if(choice == 6){
            System.out.println("\n--- Exit ---\n");
            break;
            
        }
}}










    



  private static void displaycrops(){
        for (int i = 0; i < Crops.seeds.length; i++){
            
                System.out.println(Crops.seeds[i]);
            }
        }
}



