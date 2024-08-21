package MethodOverriding;

public class Yamaha extends Engine{         //Non-abstract class Yamaha inherits the abstract class Engine

    Yamaha(double price, int stroke, String type) {     //Constructor for Yamaha for initialization
                    // As abstract class can not be instantiated , the child class should have the constructor and instantiation
        super(price, stroke, type);     //super keyword used to initialize the variables from Engine class
    }

    @Override
    void run() {   // implementation of the abstract method run() inherited from Engine
                  // A child class which has abstract method as parent then it has to implement all the abstract method from the parent
        System.out.println("Yamaha bikes are running using the "+this.stroke+" stroke engine of type "+this.type);
        System.out.println("yamaha bikes are costs around "+this.price);
    }

    @Override
    public void details()  // overriding the normal method from the parent class
    {
        super.details();  // super keyword used to call the implementation of the overriding method details() from its parent
                          // this will make the details() from Engine class to execute first and then the code in Yamaha class will be executed
        System.out.println("this method is overridden in class yamaha");
    }
}
