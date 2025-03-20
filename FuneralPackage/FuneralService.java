package FuneralPackage;
public class FuneralService {
   private String clientName;
   private String serviceType;
   private String dateOfService;
   private double cost;
   private String funeralDirector;
   
   public FuneralService(String clientName, String serviceType, String dateOfService, double cost, String funeralDirector){
    this.clientName=clientName;
    this.serviceType=serviceType;
    this.dateOfService=dateOfService;
    this.cost=cost;
    this.funeralDirector=funeralDirector;
   }
   public String getClientName(){
    return clientName;
   }
   public void setClientName(String clientName){
    this.clientName=clientName;
   }
   public String getServiceType(){
    return serviceType;
   }
   public void setServiceType(String serviceType){
    this.serviceType=serviceType;
   }
   public String getDateOfService(){
    return dateOfService;
   }
   public void setDateOfService(String dateOfService){
    this.dateOfService=dateOfService;
   }
   public double getcost(){
    return cost;
   }
   public void setCost(double cost){
    this.cost=cost;
   }
   public String getFuneralDirector(){
    return funeralDirector;
   }
   public void setFuneralDirector(String funeralDirector){
    this.funeralDirector=funeralDirector;
   }
   public void displayServiceDetails(){
    System.out.println("Client Name: " + clientName);
    System.out.println("Service Type: " + serviceType);
    System.out.println("Date Of Service: " + dateOfService);
    System.out.println("Cost: " + cost);
    System.out.println("Funeral Director: " + funeralDirector);
   }
}
