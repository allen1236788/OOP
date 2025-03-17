package Inheritance;

public class SuperEmployeeTest {
    public static void main(String[] args) {
        SubContractual carpenter = new SubContractual(2025, "de la Cruz", "Juan",4001,"Carpenter");

        /* carpenter.setContractNUmber(4001);
        carpenter.setDesignation("Carpenter"); */

        carpenter.displayInfo();
    }
}
