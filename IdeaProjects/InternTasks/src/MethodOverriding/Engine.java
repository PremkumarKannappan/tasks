package MethodOverriding;

public abstract class Engine {      //Abstract class Engine for overriding
    public double price;
    public int stroke;
    public String type;

    Engine(double price,int stroke,String type){    // Constructor for the abstract class for initialization
        this.price=price;
        this.stroke=stroke;
        this.type=type;
    }
    public static void start()   //static method for the abstract class
    {
        System.out.println("Abstract class Engine having a static method");
    }
    abstract void run();    //Abstract method to be overridden by implementing

    public void details()   //Non-abstract method to be overridden
    {
        System.out.println("Type: " + type);
        System.out.println("Price: " + price);
        System.out.println("Stroke: "+stroke);
    }
}
