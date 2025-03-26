import java.util.Scanner;

/* import InheritanceQuiz.Invoice;
 */public class AccountReceivable  {
    public static void main(String[] args) {
        Scanner S= new Scanner(System.in);
        boolean Y=true;
        while(Y){
    
        String invoiceNum,purchase,nem,run;
        double inAmount;
        System.out.println("\nEnter Invoice Number: ");
        invoiceNum=S.nextLine();
        System.out.println("Enter Purchase Date (YYYY-MM-DD): ");
        purchase=S.nextLine();
        System.out.println("Enter Customer Name: ");
        nem=S.nextLine();
        System.out.println("Enter Invoice Amount: ");
        inAmount=S.nextDouble();
        S.nextLine();

        System.out.println("\nInvoice Created Successfully!\n");

        Invoice invoice=new Invoice(invoiceNum,purchase,nem,inAmount);

        invoice.displayInvoiceDetails();

        double amPaid,r=0,pay=0;
        String payDate;
        int payMethod;
        String date,checkNum;
        System.out.println("\n------------------------------");

        
        while(Y){   
            if(inAmount==pay){
                System.out.println("\nNo balance left!");
                System.out.println("\nDo you want to run again? (Y/N): \n");
                String runn=S.nextLine();
                if(runn.equalsIgnoreCase("Y")){
                r=0;
                pay=0;
                break;
                }else{
                    System.exit(0);;
                }
            }else{
            while(true){
                r=inAmount-r;

                System.out.println("\nEnter Amount Paid: ");
                amPaid=S.nextDouble();
                S.nextLine();
                
               pay=pay+amPaid;
                
                    if(amPaid<=0){
                    System.out.println("Error: Payment must be greater than zero!");
                    }else if(amPaid>r){
                        System.out.println("Error: Payment amount exceeds invoice amount!");    
                    }else{
                        break;
                    }}
                    r=r-amPaid;
                    

            System.out.println("Enter Payment Date (YYYY-MM-DD): ");
            payDate=S.nextLine();
            System.out.println("Enter Payment Method (1 for Cash, 2 for Check): ");
            payMethod=S.nextInt();
            S.nextLine();
            

            if (payMethod==1){
                System.out.println("\nPayment Recorded Successfully!\n");
                System.out.println("\n------------------------------");
                Payment payment = new Payment(invoiceNum, purchase, nem, inAmount, amPaid, payDate, "Cash");
                payment.displayInvoiceDetails();

            }else{
                System.out.println("Is the check on-date or post-dated? (O for On-date, P for Post-dated): ");
                date=S.nextLine();
                if(date.equalsIgnoreCase("O")){
                    System.out.println("Enter Check Number: ");
                    checkNum = S.nextLine();
                    System.out.println("\nPayment Recorded Successfully!\n");
                    
                    System.out.println("\n------------------------------");
                    Payment payment = new Payment(invoiceNum, purchase, nem, inAmount, amPaid, payDate, "Check");
                    payment.displayInvoiceDetails();

                    if(date.equalsIgnoreCase("O")){
                    System.out.println("Check Type: On-date");
                    System.out.println("Check Number: "+checkNum);
                 
        }
            }
                }
                
                if (r==0){
                    System.out.print("Payment Status: Fully Paid");
                }else if(r>0){
                    System.out.printf("Remaining Balance: %.2f\n",r );
                }
                System.out.println("\n------------------------------");
            }
            
        System.out.print("\nDo you want to run this invoice again? (Y/N): \n");
        run=S.nextLine();
                if(run.equalsIgnoreCase("N")){
                   System.exit(1);
                }
        }

        }

}}