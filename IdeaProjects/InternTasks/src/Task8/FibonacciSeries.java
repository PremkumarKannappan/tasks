package Task8;

import java.math.BigInteger;
import java.util.Scanner;
public class FibonacciSeries {
    public int getCount() {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        boolean isSuccess = false;
        do {
            try {
                int n = scanner.nextInt();
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
                scanner.nextLine();
            }
        } while (!isSuccess);
        return count;
    }
    public BigInteger [] calculateFibonacci(int count) {
        BigInteger sum = BigInteger.ZERO;
        BigInteger ele1 = BigInteger.ONE, ele2 = BigInteger.ONE, temp;
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
        return fib;
    }
    public void printFibonacci(BigInteger[] fib) {
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger j : fib) {
            System.out.print(j + " ");
            sum = j.add(sum);
        }
        System.out.println("\nSum of the series is :" + sum);
    }
}