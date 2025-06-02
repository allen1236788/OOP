package CropManagement;

public class corn extends Crops{
    
    public corn(String cropType,int cropsQuantity, double cropPrice, double fertilizerPrice,double pestcontrolPrice) {
        super("Corn", cropsQuantity, cropPrice, fertilizerPrice,pestcontrolPrice);
        this.cropsQuantity = cropsQuantity;
        this.fertilizerPrice = fertilizerPrice;
        this.pestcontrolPrice=pestcontrolPrice;
    }



    
}
