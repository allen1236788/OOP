import InheritanceQuiz.Invoice;

public class Payment extends Invoice{
    private double amountPaid;
    private String paymentDate;
    private String paymentMethod;
    
    public Payment(String invoiceNumber,String purchaseDate,String customerName,double invoiceAmount,double amountPaid,String paymentDate,String paymentMethod){
        super(invoiceNumber,purchaseDate,customerName,invoiceAmount);
        this.amountPaid=amountPaid;
        this.paymentDate=paymentDate;
        this.paymentMethod=paymentMethod;
    }
    @Override
    public void displayInvoiceDetails(){
        super.displayInvoiceDetails();
        System.out.println("Amount Paid: "+amountPaid);
        System.out.println("Payment Date: "+paymentDate);
        System.out.println("Payment Method: "+paymentMethod);
    }
}
