package Inheritance;

public class StudentScholar extends Student{
    private String scholarType;
    private int discountPercentage;
    
    StudentScholar(String s, String c, int a,String st,int d){
        super(s,c,a);
        scholarType=s;
        discountPercentage=d; 

    }
/*     public void setScholarType(String s){
    scholarType=s;
}

public void setDiscountPercentage(int d){
    discountPercentage=d;
} */
public String getScholarType(){
    return scholarType;
}
public int getDiscountPercentage(){
    return discountPercentage;
}
}