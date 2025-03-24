import java.util.Scanner;

import InheritanceQuiz.Invoice;
public class AccountReceivable  {
    public static void main(String[] args) {
        Scanner S= new Scanner(System.in);
     boolean g=false;
        String invoiceNum,purchase,nem;
        double inAmount;
        System.out.println("Enter Invoice Number: ");
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

        double amPaid,r;
        String payDate;
        int payMethod;
        String date,checkNum;
        System.out.println("\n------------------------------");

        /* 
        System.out.println("Enter Amount Paid: ");
        amPaid=S.nextDouble();
        S.nextLine(); */
        
        
       /*  if(amPaid>inAmount){
            System.out.println("Error: Payment amount exceeds invoice amount!");
         }else if(amPaid<0){
            System.out.println("Error: Payment must be greater than zero!");

         }else  */
       
        while(true){
            
            System.out.println("Enter Amount Paid: ");
            amPaid=S.nextDouble();
            S.nextLine();
            
          while(true){
                if(amPaid>inAmount){
                    System.out.println("Error: Payment amount exceeds invoice amount!");
                    break;
                }else if(amPaid<0){
                    System.out.println("Error: Payment must be greater than zero!");
                    
                }
                
                } break;} 
        System.out.println("Enter Payment Date (YYYY-MM-DD): ");
        payDate=S.nextLine();
        System.out.println("Enter Payment Method (1 for Cash, 2 for Check): ");
        payMethod=S.nextInt();
        S.nextLine();
        

        if (payMethod==1){
            System.out.println("\nPayment Recorded Successfully!\n");
            Payment payment = new Payment(invoiceNum, purchase, nem, inAmount, amPaid, payDate, "Cash");
            payment.displayInvoiceDetails();

            
             if (inAmount-amPaid==0){
                System.out.println("Payment Status: Fully Paid");
             }else if(inAmount-amPaid>0){
                r=inAmount-amPaid;
                System.out.printf("Remaining Balance: %.2f", r );
             }
            
             
        }else{
            System.out.println("Is the check on-date or post-dated? (O for On-date, P for Post-dated): ");
            date=S.nextLine();
            if(date.equalsIgnoreCase("O")){
                System.out.println("Enter Check Number: ");
                checkNum = S.nextLine();
                System.out.println("\nPayment Recorded Successfully!\n");
                

                Payment payment = new Payment(invoiceNum, purchase, nem, inAmount, amPaid, payDate, "Check");
        
                payment.displayInvoiceDetails();

                if(date.equalsIgnoreCase("O")){
                System.out.println("Check Type: On-date");
                System.out.println("Check Number: "+checkNum);
                
                if (inAmount-amPaid==0){
                    System.out.println("Payment Status: Fully Paid");
                 }else if(inAmount-amPaid>0){
                    r=inAmount-amPaid;
                    System.out.printf("Remaining Balance: %.2f", r );
                 }
                
                }
                
            } 
            
        }

    


}}

