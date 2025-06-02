package CropManagement;


public class sugarCane extends Crops{
    
    public sugarCane(String cropType,int cropsQuantity, double cropPrice, double fertilizerPrice,double pestcontrolPrice) {
        super("sugar cane", cropsQuantity, cropPrice, fertilizerPrice,pestcontrolPrice);
        this.cropsQuantity = cropsQuantity;
        this.fertilizerPrice = fertilizerPrice;
        this.pestcontrolPrice=pestcontrolPrice;
    }




}