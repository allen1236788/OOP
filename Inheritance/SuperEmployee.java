package Inheritance;

public class SuperEmployee {
    private int empNum;
    private String empLastName;
    private String empFirstName;

    SuperEmployee(int n, String ln, String fn){
        empNum=n;
        empLastName=ln;
        empFirstName=fn;
    }

    public int getEmpNum(){
        return empNum;
    }
    public String getLastName(){
        return empLastName;
    }
    public String getFirstName(){
        return empFirstName;
    }

    public void displayInfo(){
        System.out.println("Emp Number: "+ getEmpNum());
        System.out.println("Lastname: " + getLastName());
        System.out.println("Firstname: " + getFirstName());
    }
}
