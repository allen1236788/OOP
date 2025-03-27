package AccountReceivables;

public class Invoice {
    private String invoiceNumber;
    private String purchaseDate;
    private String customerName;
    private double amount;

 
public Invoice(String invoiceNumber,String purchaseDate,String customerName,double amount){
    this.invoiceNumber=invoiceNumber;
    this.purchaseDate=purchaseDate;
    this.customerName=customerName;
    this.amount=amount;
}

public String getInvoiceNumber(){
    return invoiceNumber;
}
public String getPurchaseDate(){
    return purchaseDate;
}
public String getCustomerName(){
    return customerName;
}
public double getAmount(){
    return amount;
}

public void displayInvoiceDetails(){
    System.out.println("Invoice Number: "+ invoiceNumber);
    System.out.println("Purchase Date: "+purchaseDate);
    System.out.println("Customer Name: "+ customerName);
    System.out.println("Amount: "+ amount);
}
}