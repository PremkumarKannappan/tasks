public class methodOverloading
{
    public int min(int a,int b)
    {
        return Math.min(a, b);
    }
    public int min(int a,int b,int c)
    {
        return Math.min(Math.min(a,b),c);
    }
    public static void main(String[] args) {
        methodOverloading m = new methodOverloading();
        int n= m.min(5,4);
        int n1 =m.min(5,4,2);
        System.out.println(n);
        System.out.println(n1);
    }
}
