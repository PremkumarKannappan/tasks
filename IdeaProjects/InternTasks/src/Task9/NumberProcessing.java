package Task9;

import java.util.ArrayList;
import java.util.Scanner;

public class NumberProcessing {
    public int calculateSum(ArrayList<Integer> arr ){
        int sum=0;
        for (int i=0;i<arr.size();i++)
        {
            sum +=arr.get(i);
        }
        return sum;
    }
    public int reverseOrder(ArrayList<Integer> arr)
    {
        int result =0;
        for(int i=arr.size()-1;i>=0;i--)
        {
            result= result*10 + arr.get(i);
        }
        return result;
    }
    public int findGreatest(ArrayList<Integer> arr)
    {
        int biggest=arr.get(0);
        for (int k=1; k<arr.size(); k++)
        {
            if (arr.get(k)>arr.get(k-1))
            {
                biggest = arr.get(k);
            }
        }
        return biggest;
    }
    public int findSmallest(ArrayList<Integer> arr)
    {
        int smallest=arr.get(0);
        for (int k=0; k<arr.size(); k++)
        {
            if (smallest>arr.get(k))
            {
                smallest = arr.get(k);
            }
        }
        return smallest;
    }
    public int findIndex(ArrayList<Integer> arr,int number)
    {
        int index=-1;
        for (int i = 0; i < arr.size(); i++) {
            if (number == arr.get(i))
            {
                index=i+1;
                System.out.println("Index of the value is:"+index);
            }
        }
        return index;
    }
    public void printToString(ArrayList<Integer> arr)
    {
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
    }
    public int findMidElement(ArrayList<Integer> arr) {
    int index =-1;
    if(arr.size()==0)
    {
        return index;
    }
    if(arr.size()%2==0)
    {
        index=arr.size()/2;
    }
    else
    {
        index=arr.size()/2-1;
    }
    return index;
    }
    public void isAmstrong(ArrayList<Integer> arr,int number)
    {
        int sum =0 ,n = arr.size();
        for (int i : arr)
        {
            sum += Math.pow(i,n);
        }
        if(sum==number)
        {
            System.out.println("The given number is AMSTRONG");
        }
        else {
            System.out.println("The given number is not AMSTRONG");
        }
    }
    public int checkCount(ArrayList<Integer> arr,int number)
    {
        int count=0;
        for (int i : arr)
        {
            if(number == i)
            {
                count++;
            }
        }
        return count;
    }
    public void replaceNumber(ArrayList<Integer> arr,int index,int replacingNumber)
    {
        arr.remove(index);
        arr.add(index, replacingNumber);
        int sum =0 ;
        for(int i : arr)
        {
            sum = sum * 10 + i ;
        }
        System.out.println("After Replacing the number is:" + sum);
    }
}
