package CropManagement;


public abstract class Crops{
protected String cropType;
protected int cropsQuantity;
protected double cropPrice;
protected double fertilizerPrice;
protected double pestcontrolPrice;
//rotected double laborPay;


protected static Crops[] seeds = new Crops[4];

 static {
        seeds[0] = new sugarCane("Sugar Cane",100, 0.0, 0.0,7999);  
        seeds[1] = new riceGrain("Rice Grain" ,100, 1200.0, 1581,7999);  
        seeds[2] = new corn("Corn",100, 1000.0, 1581,7999); 
        seeds[3] = new eggPlant("Egg Plant",100, 1100.0, 1581,7999); 
 }

 public Crops(String cropType,int cropsQuantity, double cropPrice,double fertilizerPrice,double pestcontrolPrice){
    this.cropType=cropType;
    this.cropsQuantity=cropsQuantity;
    this.cropPrice=cropPrice;
    this.fertilizerPrice=fertilizerPrice;
    this.pestcontrolPrice=pestcontrolPrice;
 }

 @Override 
    public String toString() {
        return "Crop Type: " +  cropType + " | Crop Quantity: " + cropsQuantity;
    }
}