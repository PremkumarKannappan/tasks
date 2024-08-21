package InterfaceExample;

public interface WildAnimal
{   int a = 0;
    public void sound();
    public void child();
    default void type()
    {
        System.out.println("These animals are wild animals");
    }

}
