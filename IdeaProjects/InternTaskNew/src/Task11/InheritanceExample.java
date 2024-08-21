package Task11;

public class InheritanceExample {
    private String name;
    public void setName(String name)
    {
        this.name = "MR"+name;
    }
    public String getName()
    {
        return this.name;
    }
    public int greatestNumber(int a, int b)
    {
        if(a>b)
            return a;
        else
            return b;
    }
    public int greatestNumber(int a, int b, int c)
    {
        if(a>b && a>c)
            return a;
        else if (b>a && b>c)
            return b;
        else
            return c;
    }
}
