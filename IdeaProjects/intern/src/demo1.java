import java.security.Key;
import java.util.*;

public class demo1
{
    public void leap(int year)
    {
        if(year%4==0)
        {
            if(year%100==0&&year%400==0)
                System.out.println("Leap year");
            else if (year%4==0&&year%100!=0)
                System.out.println("Leap year");
            else
                System.out.println("Not Leap year");
        }
        else
        {
            System.out.println("Not Leap year");
        }
    }
    public double STDDEV(int [] arr)
    {
        int n = arr.length;
        int sum = 0;
        for(int i: arr)
        {
            sum += i;
        }
        int avg = sum/n;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i:arr)
        {
            int x= i-avg;
             int dev = x*x;
            list.add(dev);
        }
        double stddev =0;
        for (int i: list)
        {
            stddev += (double) i /n;
        }
        return Math.sqrt(stddev);
    }

    public void Printer(Map map1,int key){
        Map map2 = new HashMap();
        map2 = (Map) map1.get(key);
        System.out.println("NAME:"+map2.get("NAME").toString());
        System.out.println("AGE:"+map2.get("Age").toString());
        System.out.println("ADDRESS:"+map2.get("Address").toString());
        System.out.println("PHONE:"+map2.get("Phone").toString());
        System.out.println("DEPARTMENT:"+map2.get("Department").toString());
    }
}
