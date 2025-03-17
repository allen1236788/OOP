package Inheritance;

public class PackageTest {
    public static void main(String[] args) {

         PackageInsured p1=new PackageInsured(2, 'M');
         PackageInsured p2 = new PackageInsured(12, 'T');
         PackageInsured p3 = new PackageInsured(25, 'A');

         p1.display();
         p2.display();
         p3.display();
    }
}

