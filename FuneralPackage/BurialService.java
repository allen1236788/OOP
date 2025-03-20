package FuneralPackage;
public class BurialService extends FuneralService {
    private String cementaryName;

    public BurialService(String clientName, String serviceType, String dateOfService, double cost, String funeralDirector,String cementaryName){
        super(clientName,serviceType,dateOfService,cost,funeralDirector);
        this.cementaryName=cementaryName;
    }
    public String getCementaryName(){
        return cementaryName;
    }
    public void setCementaryName(String cementaryName){
        this.cementaryName=cementaryName;
    }
    @Override
    public void displayServiceDetails(){
        super.displayServiceDetails();
        System.out.println("Cementary Name: "+cementaryName);
    }
}
