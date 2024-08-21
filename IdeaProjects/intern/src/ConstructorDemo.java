public class ConstructorDemo {
    private String name;
    ConstructorDemo() {
        System.out.println("Default Constructor called");
    }
    ConstructorDemo(String name) {
        this.name = name;
        System.out.println("Parameterised constructor called");
        System.out.println("The name is set as " + this.name);
    }
    ConstructorDemo(ConstructorDemo cd) {
        this.name = cd.name;
        System.out.println("Copy constructor called");
        System.out.println("The name is set as " + this.name);
    }
    public String getName()
    {
        this.name = "MR."+this.name;
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public static void main(String[] args) {
        ConstructorDemo obj1 = new ConstructorDemo();
        ConstructorDemo obj2 = new ConstructorDemo("Premkumar");
        ConstructorDemo obj3 = new ConstructorDemo(obj2);
        obj1.setName("Prem");
        String name = obj1.getName();
        System.out.println(name);
    }
}
