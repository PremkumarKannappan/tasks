import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public non-sealed class objectOriented extends ArrayProcess
{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        objectOriented obj = new objectOriented();
        boolean isSuccess = false;int n;
        do {
            try{
                System.out.println("Enter the size of the array");
                n = sc.nextInt();
                int [] arr = new int[n];
                int [] arr1 = new int[n];
                System.out.println("Enter the elements of the array");
                for(int i = 0; i < n; i++)
                {
                    arr[i]= sc.nextInt();
                }
                System.out.println(Arrays.toString(arr));
                System.out.println("The elements of the original array");
                for (int i : arr) {
                    System.out.print(i + " ");
                }
                int[] arr2 = obj.copyArray(arr,arr1);
                obj.sortArrayAscnd(arr);
                obj.sortArrayDescnd(arr2);
                obj.Repeat(arr2);
               isSuccess = true;
            }
            catch(Exception e){
                System.out.println(e);
                System.out.println("Please enter a valid number");
            }
        }while(!isSuccess);
    }
}
