package Checkpoint;

import java.util.ArrayList;
import java.util.Arrays;

public class Quicksort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,123,1,11,4,6};
        // Sort(arr, arr.length-1, 0);
        System.out.println(Arrays.toString(Sort(arr, arr.length-1, 0)));
    }

    public static int[] Sort(int[] arr, int high, int low){
        System.out.println(Arrays.toString(arr));
        if(arr[low]<arr[high]){
            ArrayList<int[]> par = Partition(arr, high, low);
            int pi = par.get(1)[0];
            arr = par.get(0);
            arr = Sort(arr, pi-1, low);
            arr = Sort(arr, high, pi+1);
        }
        return arr;
    }

    public static int[] Swap(int[] arr, int i, int j){
        int x = arr[i];
        arr[i] = arr[j];
        arr[j] = x;
        return arr;
    }

    public static ArrayList<int[]> Partition (int[] arr, int high, int low){
        int pivot = arr[high];
        int i = (low-1);
        for (int j = low; j <= high-1; j++){
            if (arr[j] < pivot){
                i++;
                arr = Swap(arr, i, j);
                System.out.println(Arrays.toString(arr));
            }
        }
        arr = Swap(arr, i+1, high);
        return new ArrayList<int[]>(Arrays.asList(arr, new int[]{i + 1}));
    }
}
