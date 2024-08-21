import java.math.BigInteger;
import java.util.Scanner;
public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ifQuit =0;
        do {
            BigInteger sum = BigInteger.ZERO;
            BigInteger ele1 = BigInteger.ONE, ele2 = BigInteger.ONE, temp;
            System.out.println("Enter the number of elements to be printed in the series: ");
            int count = 0;
            boolean isSuccess = false;
            do {
                try {
                    int n = sc.nextInt();
                    if (n < 0) {
                        throw new Exception("Invalid input : Negative number");
                    }
                    if (n == 0) {
                        throw new Exception("Invalid input : Zero number");
                    }

                    count = n;
                    isSuccess = true;

                } catch (Exception e) {
                    System.out.println(e.getMessage() + "\nEnter a valid positive number");
                    sc.nextLine();
                }
            } while (!isSuccess);
            BigInteger[] fib = new BigInteger[count];
            if (count == 1) {
                fib[0] = BigInteger.valueOf(1);
            } else if (count == 2) {
                fib[0] = BigInteger.valueOf(1);
                fib[1] = BigInteger.valueOf(1);
            } else {
                fib[0] = BigInteger.valueOf(1);
                fib[1] = BigInteger.valueOf(1);
                for (int i = 2; i < count; i++) {
                    temp = ele1.add(ele2);
                    fib[i] = temp;
                    ele1 = ele2;
                    ele2 = temp;
                }

            }
            for (BigInteger j : fib) {
                System.out.print(j + " ");
                sum = j.add(sum);
            }
            System.out.println("\nSum of the series is :" + sum);
            System.out.println("If you want to continue enter 1 or 0:");
            ifQuit = sc.nextInt() ;
        }while(ifQuit !=0);
    }
}