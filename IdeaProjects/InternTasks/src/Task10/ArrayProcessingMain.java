package Task10;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayProcessingMain {
    public static boolean validateSizeOfArray(int size)
    {
        boolean isValid = false;
        try
        {
            if(size < 0)
            {
                throw new Exception("Size cannot be negative");
            }
            if(size ==  0)
            {
                throw new Exception("Size cannot be zero");
            }
            isValid = true;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage()+":\tInvalid size");
        }
        return isValid;
    }

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        ArrayProcessing obj = new ArrayProcessing() ;
        boolean isSuccess = false;int size;
        do {
                System.out.println("Enter the size of the array");
                boolean isSizeValid ;
                do {
                    size = sc.nextInt();
                    isSizeValid = validateSizeOfArray(size);
                }while(!isSizeValid);
                int [] arr = new int[size];
                int [] arr1 = new int[size];
                System.out.println("Enter the elements of the array");
                for(int i = 0; i < size; i++)
                {
                    arr[i]= sc.nextInt();
                }
                System.out.println(Arrays.toString(arr));
                System.out.println("The elements of the original array");
                for (int i : arr) {
                    System.out.print(i + " ");
                }
                int[] arr2 = obj.copyArray(arr,arr1);
                obj.sortArrayAscending(arr);
                obj.sortArrayDescending(arr2);
                obj.repeatingElements(arr2);
            System.out.println("If you want to continue enter 'Y' or 'N' to exit");
            char ch = sc.next().charAt(0);
            if(ch == 'Y' || ch == 'y')
            {
                isSuccess = true;
            }
        }while(isSuccess);
    }
}
