package InterfaceExample;

public class Elephant implements WildAnimal {

    @Override
    public void sound() {
        System.out.println("Elephant trumpets");
    }

    @Override
    public void child() {
        System.out.println("Elephant's young is called as calf");
    }


}
