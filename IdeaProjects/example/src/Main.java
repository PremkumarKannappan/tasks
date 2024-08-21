import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num1,num2,num3;
        float fno1,fno2;
        char c1,c2;
        String str1,str2,str3;
        boolean b1,b2;

        System.out.print("Hello and welcome!");
        num1 = in.nextInt();
        num2 = in.nextInt();
        num3 = in.nextInt();
        fno1  = (float) num1 / num2;
        fno2 = (float) num2 / num3;
        str1 = "Welcome to Java";
        str2 = "first program" ;
        str3 = str1 + str2;
        System.out.println(fno1);
        System.out.println(fno2);
        System.out.println(str3);
        c1 = str1.charAt(0);
        c2 = str1.charAt(str1.length()-1);
        System.out.println(c1+""+c2);
        if (fno1 > fno2)
        {
            b1 = true;
            b2 = false;
            System.out.println(b1+""+b2);
        }
        else
        {
            b1= false;
            b2 = true;
            System.out.println(b1+""+b2);
        }
    }
}