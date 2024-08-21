package Task10;

import java.util.ArrayList;

public  class ArrayProcessing
{
    public int[] copyArray(int[] arr,int[] arr1) {
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = arr[i];
        }
        System.out.println("\nThe elements of the copy array");
        for (int i : arr1) {
            System.out.print(i + " ");
        }
        return arr1;
    }
    public void sortArrayAscending(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("\nAfter sorting the array in ascending order The elements of the array are");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    public void sortArrayDescending(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("\nAfter sorting the array in descending order The elements of the array");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    public void repeatingElements(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList <Integer> counter = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    if(!list.contains(arr[i])){
                        list.add(arr[i]);
                        counter.add(1);
                    }
                    int ele = list.indexOf(arr[i]);
                    counter.set(ele, counter.get(ele) + 1);
                }
            }
        }
        System.out.println("\nThe elements are repeating in the array");
        for (int i=0;i<list.size();i++) {
            System.out.println(list.get(i) + ","+counter.get(i));
        }
    }
}

