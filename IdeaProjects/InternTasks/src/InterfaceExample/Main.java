package InterfaceExample;

public class Main
{
    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        tiger.type();
        System.out.println();

        tiger.sound();
        tiger.child();
        System.out.println();

        Elephant elephant = new Elephant();
        elephant.sound();
        elephant.child();

        elephant.type();

        Animal animal = (animalName) -> System.out.println("The animal "+ animalName +" is a Wild animal");
        animal.display("Tiger");
    }
}
