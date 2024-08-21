package Task9;

import java.util.ArrayList;
import java.util.Scanner;

public class NumberProcessingMain {
    int n1;
    public static void main(String[] args) {
        int num;
        NumberProcessingMain obj = new NumberProcessingMain();
        NumberProcessing numProc = new NumberProcessing();
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("Number processing");
        System.out.println("Enter the number to be processed");
        num = obj.getNumber();
        int temp =num;Integer cont = 0;
        ArrayList<Integer> arr = new ArrayList<Integer>();int res;
        do
        {
            res= num%10;
            num/=10;
            arr.add(0,res);
        }while (num>0);
        do
        {
            System.out.println("Enter your choice from the below list");
            System.out.print("\n 1.Sum of Digits \t 2.Reverse Order \t 3.Find Biggest Number \t 4.Find Smallest Number");
            System.out.print("\t 5.Find Average \t 6.Finding Index position value \t 7.To Print String Format ");
            System.out.print("\n 8.Find the Mid elements \t 9.Find Amstrong Number \t 10.Total Number Of Counts \t 11.Particular Number Repeating Count \t 12.Replaceing Number\t:");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    int sum = numProc.calculateSum(arr);
                    System.out.println("Sum of digits for the given number is"+sum);
                    break;
                case 2:
                    int result= numProc.reverseOrder(arr);
                    System.out.println("Reverse order for the given number is"+result);
                    break;
                case 3:
                    int biggest= numProc.findGreatest(arr);
                    System.out.println("Biggest number is"+biggest);
                    break;
                case 4:
                    int smallest= numProc.findSmallest(arr);
                    System.out.println("Smallest number is"+smallest);
                    break;
                case 5:
                    int avg;
                    int sum1 = numProc.calculateSum(arr);
                    avg = sum1/arr.size();
                    System.out.println("Average of the given number is:\t"+avg);
                    break;
                case 6:
                    System.out.println("Enter the value to find index");
                    int number= obj.getNumber();
                    int index = numProc.findIndex(arr,number);
                    if(index == -1)
                    {
                        System.out.println("Element not found");
                    }
                    else {
                        System.out.println("Element found at index "+index);
                    }
                    break;
                case 7:
                    numProc.printToString(arr);
                    break;
                case 8:
                    int midIndex= numProc.findMidElement(arr);
                    if(midIndex != -1)
                    {
                        System.out.println("the mid element is :"+arr.get(midIndex));
                    }
                    else
                    {
                        System.out.println("There is no Mid element");
                    }
                    break;
                case 9:
                    numProc.isAmstrong(arr,temp);
                    break;
                case 10:
                    System.out.println("the total number of count in the given number is"+ arr.size());
                    break;
                case 11:
                    System.out.println("enter the particular number to check count");
                    int particularNumber = obj.getNumber();
                    int count = numProc.checkCount(arr, particularNumber);
                    if(count !=0)
                    {
                        System.out.println("the total number of count:"+count);
                    }
                    else
                    {
                        System.out.println("the given element is not found");
                    }
                    break;
                case 12:
                    System.out.println("enter the number to be replaced ");
                    boolean isSuccess = false; int indexOfValue, replacedNumber;
                    do {
                        replacedNumber = obj.getNumber();
                        indexOfValue = arr.indexOf(replacedNumber);
                        if(indexOfValue == -1)
                        {
                            System.out.println("the entered no is not found please reenter"+temp);
                        }
                        isSuccess = true;
                    }while(!isSuccess);
                    System.out.println("enter the number to replace ");
                    int replacingNumber = obj.getNumber();
                    numProc.replaceNumber(arr,indexOfValue,replacingNumber);
                    break;
                default:
                    System.out.println("Invalid Request Please enter a valid option");
                    break;
            }
            boolean isContinue = false;
            System.out.println("\n if you want to continue enter 1 else enter 0");
            do {
                cont = sc.nextInt();
                if(cont == 1 || cont == 0)
                {
                    isContinue = true;
                }
            }while(!isContinue);
        }while(cont !=0);

    }
    public int getNumber(){
        int number = 0;
        Scanner sc = new Scanner(System.in);
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

                number = n;
                isSuccess = true;

            } catch (Exception e) {
                System.out.println(e.getMessage() + "\nEnter a valid positive number");
                sc.nextLine();
            }
        } while (!isSuccess);
        return number;
    }

}
