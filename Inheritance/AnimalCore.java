package Inheritance;

//Parent Class
class Animal{
    //Attribiute
    String name;


//Constuctor
public Animal(String name){
    this.name=name;
}

//Method
public void speak(){
    System.out.println(name + "makes a sound");
}
}

//Child class
class Dog extends Animal{

    //Constructor
    public Dog(String name){
        //Calling the constructor of the parent class (Animal)
        super(name);
    }

    //Additional method specific to Dog
    public void display(){
        System.out.println(name+" is a dog");
    }
}

public class AnimalCore{
    public static void main(String[] args) {
        //Creating an instance of the Dog class
        Dog dog =new Dog("Buddy");

        //Calling inherited method
        dog.speak(); //Outputs: Buddy makes a sound

        //Calling Dog-specific method
        dog.display(); //Outputs: Buddu is a dog
    }
}