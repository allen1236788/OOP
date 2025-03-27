package AccountReceivables;
import java.util.Scanner;
public class Payment extends Invoice{
    private double amountPaid;
    private String paymentDate;
    private String paymentMethod;
    private String checkNumber;
    private String checkType;

    public Payment(String invoiceNumber,String purchaseDate,String customerName,double amount,double amountPaid,String paymentDate,String paymentMethod){
        super(invoiceNumber,purchaseDate,customerName,amount);
        this.amountPaid=amountPaid;
        this.paymentDate=paymentDate;
        this.paymentMethod=paymentMethod;
        this.checkNumber="";
        this.checkType="";
    }
    public Payment(String invoiceNumber,String purchaseDate,String customerName,double amount,double amountPaid,String paymentDate,String paymentMethod, String checkNumber, String checkType ){
        super(invoiceNumber,purchaseDate,customerName,amount);
        this.amountPaid=amountPaid;
        this.paymentDate=paymentDate;
        this.paymentMethod=paymentMethod;
        this.checkNumber="";
        this.checkType="";
    }
    Scanner scanner= new Scanner(System.in);
    double remainingBalance=amount;
    boolean isFullyPaid=false;
    while(!isFullyPaid){
        double amountPaid;
        while(true){
        System.out.println("\nEnter Amount Paid: ");
        amountPaid=scanner.nextDouble();
    
        if(amountPaid<=0){
            System.out.println("Error: Payment must be greater than zero!");
            continue;
        }else if(amountPaid>remainingBalance){
            System.out.printf("Error: Payment amount exceeds remaining balance(%.2f)!\n",remainingBalance);    
            continue;
        }
            break;   
        }
    
    scanner.nextLine();

    System.out.println("Enter Payment Date (YYYY-MM-DD): ");
    String paymentDate=scanner.nextLine();

    int paymentChoice;
    String paymentMethod="";
    while(true){
        System.out.println("Enter Payment Method (1 for Cash, 2 for Check): ");
        paymentChoice=scanner.nextInt();

        if(paymentChoice==1){
            paymentMethod="Cash";
            break;
        }else if(paymentChoice==2){
            paymentMethod="Check";
            break;
        }else{
            System.out.println("Error:Invalid Choice! Please enter 1 for Cash, 2 for Check.");
        }
    }
        scanner.nextLine();

        Payment payment;
        if(paymentMethod.equalsIgnoreCase("Check")){
            String checkType="";
            while ((true)) {  
                System.out.println("Is the check on-date or post-dated? (O for On-date, P for Post-dated): ");
                String checkChoice=scanner.nextLine().toUpperCase();

            if(checkChoice.equals("O")){
                checkType="On-date";
                break;
            }else if(checkChoice.equals("P")){
                checkType="Post-dated";
                break;
            }else{
                System.out.println("Error:Invalid choice! Enter O for On-date or P for Post-dated.");
            }
            }

            System.out.println("Enter Check Number: ");
            String checkNumber=scanner.nextLine();

            payment=new Payment(invoiceNumber,purchaseDate,customerName,amount,amountPaid,paymentDate,paymentMethod,checkNumber,checkType);
        }else{
            payment=new Payment(invoiceNumber,purchaseDate,customerName,amount,amountPaid,paymentDate,paymentMethod);
        }
        remainingBalance=amountPaid;
        System.out.println("\nPayment Recorded Successfully!\n");
        payment.displayPaymentDetails();

        if (remainingBalance==0){
            System.out.println("invoice dully paid. No remaining balance.");
            isFullyPaid=true;
        }else{
            System.out.printf("Remaining Balance: %.2f\n", remainingBalance);
        }
    }

    public void displayPaymentDetails(){
        super.displayInvoiceDetails();
        System.out.println("Amount Paid: "+amountPaid);
        System.out.println("Payment Date: "+paymentDate);
        System.out.println("Payment Method: "+paymentMethod);

        if(paymentMethod.equalsIgnoreCase("Check")){
            System.out.println("Check Type: " + checkType);
            System.out.println("Check Number: "+checkNumber);
        }
    }
}