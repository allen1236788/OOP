package Inheritance;

public class Student {
    private String spn;
    private String course;
    private int age;

    Student(String s, String c, int a){
        spn=s;
        course=c;
        age=a;
    }
    /* public void setSPN(String s){
        spn=s;
    }
    public void setCourse(String c){
        course=c; 
    }
    public void setAge(int a){
        age=a;
    } */
    public String getSPN(){
        return spn;
    }   
    public String getCourse(){
        return course;
    }   
    public int getAge(){
        return age;
    }   
}
