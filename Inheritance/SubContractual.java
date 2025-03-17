package Inheritance;

public class SubContractual extends SuperEmployee {
    private int contractnum;
    private String designation;

    SubContractual(int n, String ln, String fn,int cn,String d){
        super(n,ln,fn);
        designation=d;
        contractnum=cn;
    }
    /* public void setContractNUmber(int cn){
       contractnum=cn;
    } 
    public void setDesignation(String d){
        designation=d;
    } */
    public int getContractNumber(){
        return contractnum;
    }
    public String getDesignation(){
        return designation;
    }

    public void displayInfo(){
        super.displayInfo();
        System.out.println("Contract Number: "+ getContractNumber());
        System.out.println("Designation: "+ getDesignation());
}
}
