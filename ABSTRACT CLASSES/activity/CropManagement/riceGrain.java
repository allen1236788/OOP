package CropManagement;

public class riceGrain extends Crops{
    
    public riceGrain(String cropType,int cropsQuantity, double cropPrice, double fertilizerPrice,double pestcontrolPrice) {
        super("Rice Grain", cropsQuantity, cropPrice, fertilizerPrice,pestcontrolPrice);
        this.cropsQuantity = cropsQuantity;
        this.fertilizerPrice = fertilizerPrice;
        this.pestcontrolPrice=pestcontrolPrice;
    }




}

