package Task8;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ifQuit =0;
        FibonacciSeries obj = new FibonacciSeries();
        do {

            System.out.println("Enter the number of elements to be printed in the series: ");
            int count = obj.getCount();
            BigInteger[] fibonacci = obj.calculateFibonacci(count);
            obj.printFibonacci(fibonacci);
            System.out.println("If you want to continue enter 1 or 0:");
            ifQuit = sc.nextInt() ;
        }while(ifQuit !=0);

    }
}
