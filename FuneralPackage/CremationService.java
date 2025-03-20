package FuneralPackage;
public class CremationService extends FuneralService{
    private boolean urnIncluded;

    public CremationService(String clientName, String serviceType, String dateOfService, double cost, String funeralDirector, boolean urnIncluded){
        super(clientName,serviceType,dateOfService,cost,funeralDirector);
        this.urnIncluded=urnIncluded;
    }
    public boolean isUrnIncluded(){
        return urnIncluded;
    }
    public void setUrnIncluded(boolean urnIncluded){
        this.urnIncluded=urnIncluded;
    }
    @Override
    public void displayServiceDetails(){
        super.displayServiceDetails();
        System.out.println("Urn Included: "+(urnIncluded? "Yes" : "No"));
    }
}