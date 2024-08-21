package MethodOverriding;

public class Hero extends Engine{       //Non-abstract class Hero inherits the abstract class Engine
    Hero(double price, int stroke, String type) {       //Constructor for Hero for initialization
        // As abstract class can not be instantiated , the child class should have the constructor and instantiation
        super(price, stroke, type);      //super keyword used to initialize the variables from Engine class
    }

    @Override
    void run() {
        System.out.println("Yamaha bikes are running using the "+this.stroke+"stroke engine of type "+this.type);
        System.out.println("yamaha bikes are costs around "+this.price);
    }

    @Override
    public void details() {
        System.out.println("this method is overridden in class hero");
    }
}
