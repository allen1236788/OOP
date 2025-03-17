package Inheritance;

public class PackageInsured extends Package {
    private double icost;

    PackageInsured(int w, char sm){
        super(w,sm);
    }
    public void calculateInsurance(){
        if(scost<=1.00)
        icost=2.45;
    else if(scost<=3.00)
        icost=3.95;
    else
        icost=5.55;
    }

    public void display(){
        super.display();
        calculateInsurance();
        System.out.println("Insurance Cost: "+ icost);
        System.out.println("Total CostL :"+(scost+icost));
        System.out.println("=====================");
    }
}
