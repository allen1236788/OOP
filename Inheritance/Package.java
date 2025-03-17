package Inheritance;

public class Package {
    private int weight;
    private char smethod;
    public double scost;

    Package(int w, char sm){
        weight=w;
        smethod=sm;
    }
    
    public void calculateCost(){
        if(weight<=16){
            switch(smethod){
                case'A':scost=3.00;break;
                case'T':scost=3.25;break;
                default:scost=2.15;
            }
        }
    }

    public void display(){
        calculateCost();
        System.out.println("=======================");

        System.out.println("package Weight: "+ weight);
        System.out.println("Shipping Cost: "+scost);
        System.out.println("-----------------------");
    }
}
