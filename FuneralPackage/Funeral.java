package FuneralPackage;
import java.util.ArrayList;
import java.util.Scanner;
public class Funeral {
    public static void main(String[] args) {
        ArrayList<FuneralService>services=new ArrayList<>();
        String nem;
        Scanner S= new Scanner(System.in);
        System.out.print("Enter client Name: ");
        nem=S.nextLine();


        services.add(new CremationService(nem,"Cremation","2025-03-25", 1500.00,"Alice Verja", true));
        services.add(new BurialService("Jane smith","Burial", "2025-03-26", 3000.00, "Bob Lucas", "Bacolod Public cementary"));
        services.add(new CremationService("Mark White", "Cremation","2025-03-27",1300.00,"Sally Monte", false));

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
