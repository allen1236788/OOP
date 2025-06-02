package CropManagement;

 public class eggPlant  extends Crops{
        
        public eggPlant(String cropType,int cropsQuantity, double cropPrice, double fertilizerPrice,double pestcontrolPrice) {
            super("Egg Plant", cropsQuantity, cropPrice, fertilizerPrice,pestcontrolPrice);
            this.cropsQuantity = cropsQuantity;
            this.fertilizerPrice = fertilizerPrice;
            this.pestcontrolPrice=pestcontrolPrice;
        }
    
    
    
    
    }



