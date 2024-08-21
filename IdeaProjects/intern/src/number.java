import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.pow;

public class number {
    int n1;
    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        int choice,cont;
        System.out.println("Number processing");
        System.out.println("Enter the number to be processed");
        num = sc.nextInt();
        int temp =num;
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
            System.out.print("\n 1.Sum of Digits \n 2.Reverse Order \n 3.Find Biggest Number \n 4.Find Smallest Number");
            System.out.print("\n 5.Find Average \n 6.Finding Index position value \n 7.To Print String Format ");
            System.out.print("\n 8.Find the Mid elements \n 9.Find Amstrong Number \n 10.Total Number Of Counts \n 11.Particular Number Repeating Count \n 12.Replaceing Number");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    int sum=0;
                    for (int i=0;i<arr.size();i++)
                    {
                        sum +=arr.get(i);
                    }
                    System.out.println("Sum of digits for the given number is"+sum);
                    break;
                case 2:

                    int result=0;
                    for(int i=arr.size()-1;i>=0;i--)
                    {
                        result= result*10 + arr.get(i);
                    }
                    System.out.println("Reverse order for the given number is"+result);
                    break;
                case 3:
                    int biggest= arr.get(0);
                    for (int k=1; k<arr.size(); k++)
                    {
                        if (arr.get(k)>arr.get(k-1))
                        {
                            biggest = arr.get(k);
                        }
                    }
                    System.out.println("Biggest number is"+biggest);
                    break;
                case 4:
                    int smallest= arr.get(0);
                    for (int k=0; k<arr.size(); k++)
                    {
                        if (smallest>arr.get(k))
                        {
                            smallest = arr.get(k);
                        }
                    }
                    System.out.println("Smallest number is"+smallest);
                    break;
                case 5:
                    int sum1=0,avg;
                    for (int i = 0; i < arr.size(); i++) {
                        sum1+=arr.get(i);

                    }
                    avg = sum1/arr.size();
                    System.out.println("Average of the given number is:\t"+avg);
                    break;
                case 6:
                    System.out.println("Enter the value to find index");
                    int number= sc.nextInt();boolean stat=false;
                    for (int i = 0; i < arr.size(); i++) {
                        if (number == arr.get(i))
                        {
                            int index=i+1;
                            stat = true;
                            System.out.println("Index of the value is:"+index);
                        }
                    }
                    if(!stat)
                    {
                        System.out.println("Element not found");
                    }
                    break;
                case 7:
                    for(int i:arr)
                    {
                        switch (i)
                        {
                            case 0:
                                System.out.print("zero\t");
                                break;
                            case 1:
                                System.out.print("one\t");
                                break;
                            case 2:
                                System.out.print("two\t");
                                break;
                            case 3:
                                System.out.print("three\t");
                                break;
                            case 4:
                                System.out.print("four\t");
                                break;
                            case 5:
                                System.out.print("five\t");
                                break;
                            case 6:
                                System.out.print("six\t");
                                break;
                            case 7:
                                System.out.print("seven\t");
                                break;
                            case 8:
                                System.out.print("eight\t");
                                break;
                            case 9:
                                System.out.print("nine\t");
                                break;
                        }
                    }
                    break;
                case 8:
                    if(arr.size()%2 !=0)
                    {
                        System.out.println("the mid element is :"+arr.get(arr.size()/2));
                    }
                    else
                    {
                        System.out.println("the mid element is :"+arr.get(arr.size()/2-1)+","+arr.get(arr.size()/2));
                    }
                    break;
                case 9:
                    double n = arr.size();
                    int sum2 =0;
                    for (int i=0;i<arr.size();i++) {
                        sum2 += pow(arr.get(i),n);
                    }
                    if(sum2 == temp)
                    {
                        System.out.println("the given number is an Amstrong number");
                    }
                    else {
                        System.out.println("the given number is not an Amstrong number");
                    }
                    break;
                case 10:
                    System.out.println("the total number of count in the given number is"+ arr.size());
                    break;
                case 11:
                    System.out.println("enter the particular number to check count");
                    int pno = sc.nextInt();
                    int count=0;
                    for (int i=0;i<arr.size();i++)
                    {
                        if(arr.get(i)==pno)
                        {
                            count++;
                        }
                    }
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
                    int rep= sc.nextInt();
                    int ind = arr.indexOf(rep);
                    if(ind == -1)
                    {
                        System.out.println("the entered no is not found please reenter"+temp);
                        rep =sc.nextInt();
                    }
                    System.out.println("enter the number to replace ");
                    int rep1= sc.nextInt();
                    ind=arr.indexOf(rep);
                    arr.remove(ind);
                    arr.add(ind,rep1);
                    int temp1=0;
                    for(int i=0;i<arr.size();i++)
                    {
                        temp1 =temp1 *10 + arr.get(i);
                    }
                    System.out.println("the number after replaced"+temp1);
                    break;

            }
          System.out.println("\n if you want to continue enter 1 else enter 0");
          cont= sc.nextInt();
        }while(cont !=0);

    }
}
