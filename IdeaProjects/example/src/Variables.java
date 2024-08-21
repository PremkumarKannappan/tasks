public class Variables
{
    public static String name;   // static variable
    public int id;		       //instance variable
    Variables(String name1)
    {
        this.name = name1 ;   // initializing static variable
        this.id = 15 ;
    }
    public static void main(String [] args)
    {
        int id = 10;
        Variables var = new Variables("Variables demo”);
        System.out.println(" Local Variable” + id);
        System.out.println("Instance Variable” + var.id);
        System.out. println("Static Variable” + var.name);
    }
}
