package FuneralPackage;
import java.util.ArrayList;
import java.util.Scanner;
public class Funeral {
    public static void main(String[] args) {
        ArrayList<FuneralService>services=new ArrayList<>();
        String nem,whatt,date,fd,cementary;
        double costt;
        boolean urn;
       
        Scanner S= new Scanner(System.in);
        System.out.print("Enter client Name: ");
        nem=S.nextLine();
        System.out.print("Enter Service Type: ");
        whatt=S.nextLine();
        System.out.print("Enter Date of service: ");
        date=S.nextLine();
        System.out.print("Enter Funeral director: ");
        fd=S.nextLine();

        if(whatt.equals("Cremation")){
            System.out.print("Urn Included? true/false: ");
            urn=S.nextBoolean();
            services.add(new CremationService(nem,whatt,date, 1500.00,fd, urn));
            services.add(new CremationService(nem,whatt,date, 100.00,fd, urn));

          /*   for(FuneralService service:services){
                if(service.getServiceType().equals("Cremation")){
                    System.out.println("This is a cremation service. Details:");
                }else if (service.getServiceType().equals("Burial")){
                    System.out.println("This is a burial service. Details:");
                }
                service.displayServiceDetails();
                System.out.println();
            } */
        }else{
            System.out.println("Enter Cementary name: ");
            cementary=S.nextLine();
        services.add(new BurialService(nem,whatt,date, 3000.00,fd,cementary));
        }
        for(FuneralService service:services){
            if(service.getServiceType().equals("Cremation")){
                System.out.println("This is a cremation service. Details:");
            }else if (service.getServiceType().equals("Burial")){
                System.out.println("This is a burial service. Details:");
            }
            service.displayServiceDetails();
            System.out.println();
        }
        
    }
}
