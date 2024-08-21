package InterfaceExample;

public class Tiger implements WildAnimal
{

    @Override
    public void sound() {
        System.out.println("Tiger Roars");
    }

    @Override
    public void child() {
        System.out.println("Tiger's young is called as cub");
    }


}
