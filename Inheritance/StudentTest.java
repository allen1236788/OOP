package Inheritance;

public class StudentTest{
public static void main(String[] args) {
    StudentScholar Maria =new StudentScholar("CS1014770","BSCS",17,"SM",75);

  /* Maria.setSPN("CS1014770");
    Maria.setCourse("BSCS");
    Maria.setAge(17);
    Maria.setScholarType("SM");
    Maria.setDiscountPercentage(75); */

    System.out.println("SPN# : " + Maria.getSPN());
    System.out.println("Course: "+ Maria.getCourse());
    System.out.println("Age: "+Maria.getAge());
    System.out.println("Type: " +Maria.getScholarType());
    System.out.println("discount%: "+ Maria.getDiscountPercentage());
}
}