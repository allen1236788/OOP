package AccountReceivables;
import java.util.Scanner;
public class AccountReceivableMultiplePayment {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        
       
        System.out.println("\nEnter Invoice Number: ");
        String invoiceNumber=scanner.nextLine();
        System.out.println("Enter Purchase Date (YYYY-MM-DD): ");
        String purchaseDate=scanner.nextLine();
        System.out.println("Enter Customer Name: ");
        String customerName=scanner.nextLine();
        System.out.println("Enter Invoice Amount: ");
        double amount=scanner.nextDouble();
        scanner.nextLine();

        Invoice invoice=new Invoice(invoiceNumber,purchaseDate,customerName,amount);
        
        System.out.println("\nInvoice Created Successfully!\n");
        invoice.displayInvoiceDetails();

        System.out.println("\n------------------------------");

        double remainingBalance=amount;
        
                System.out.println("Do you want to apply another payment to this invoice:(Y/N): ");
                String continuePayment=scanner.nextLine();

                if(!continuePayment.equals("Y")){
                    System.out.printf("Payment process ended. Remaining balance: %.2f\n",remainingBalance);
                }
            }
            
          
}

