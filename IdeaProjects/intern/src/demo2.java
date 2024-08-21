import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class demo2
{

    static Scanner sc = new Scanner(System.in);
    static int number=sc.nextInt();
    final int number1=sc.nextInt();
public static void start()
    {
        char choice=' ' ;int choice1;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Enter your Coice from the following list");
            System.out.println("1.Odd or Even\n2.Prime");
            choice1 = sc.nextInt();
            switch(choice1)
            {
                case 1:
                    if(number%2==0)
                    {
                        System.out.println("Even number");
                    }
                    else
                    {
                        System.out.println("Odd number");
                    }
                    break;
                case 2:
                    boolean isPrime = true;
                    for(int i=2;i<number/2;i++)
                    {
                        if(number%i==0)
                        {
                            isPrime = false;
                        }
                    }
                    if (isPrime)
                    {
                        System.out.println("Prime number");
                    }
                    else
                    {
                        System.out.println("Not Prime number");
                    }
                    break;
            }
            System.out.println("Do you want to continue? (Y/N)");
            choice = sc.next().charAt(0);
        }while ( choice =='Y'||choice == 'y');

    }

//    public static void main(String[] args) {
//        System.out.println("Welcome to the Choice Calculator");
//        demo2 obj = new demo2();
//        start();
//        obj.number();
//    }
    public void number()
    {
        start();
        System.out.println("the final number entered is"+number1);
    }
}
