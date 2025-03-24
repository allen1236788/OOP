package InheritanceQuiz;

public class Invoice {
    private String invoiceNumber;
    private String purchaseDate;
    private String customerName;
    private double invoiceAmount;

 
public Invoice(String invoiceNumber,String purchaseDate,String customerName,double invoiceAmount){
    this.invoiceNumber=invoiceNumber;
    this.purchaseDate=purchaseDate;
    this.customerName=customerName;
    this.invoiceAmount=invoiceAmount;
}
/* public String getInvoicenumber(){
    return invoiceNumber;
}
public String getPurchaseDate(){
    return purchaseDate;
}
public String getCustomerName(){
    return customerName;
}
public double getInvoiceAmount(){
    return invoiceAmount;
}
public void setInvoicenumber(String invoiceNumber){
    this.invoiceNumber=invoiceNumber;
}
public void setPurchaseDate(String purchaseDate){
    this.purchaseDate=purchaseDate;
}
public void setCustomerName(String customerName){
    this.customerName=customerName;
}
public void setInvoiceAmount(double invoiceAmount){
    this.invoiceAmount=invoiceAmount; 
}  */
public void displayInvoiceDetails(){
    System.out.println("Invoice Number: "+ invoiceNumber);
    System.out.println("Purchase Date: "+purchaseDate);
    System.out.println("Customer Name: "+ customerName);
    System.out.println("Amount: "+ invoiceAmount);
}
}