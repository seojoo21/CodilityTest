package Sorting;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int arr[], int arrLength){
        if(arrLength < 2) return;

        int mid = arrLength / 2;
        int[] left = new int[mid];
        int[] right = new int[arrLength-mid];

        for(int i=0; i<mid; i++){
            left[i] = arr[i];
        }

        for(int i=mid; i<arrLength; i++){
            right[i-mid] = arr[i];
        }

        mergeSort(left, mid);
        mergeSort(right, arrLength-mid);

        merge(arr, left, right, mid, arrLength-mid);
    }

    public static void merge(int[] arr, int[] left, int[] right, int leftLen, int rightLen){
        int i=0, j=0, k=0;

        while(i<leftLen && j<rightLen){
            if(left[i] <= right[j]){
                arr[k++] = left[i++];
            }else{
                arr[k++] = right[j++];
            }
        }
        while(i<leftLen){
            arr[k++] = left[i++];
        }
        while(j<rightLen){
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args){
        int[] actual = { 5, 1, 6, 2, 3, 4 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        mergeSort(actual, actual.length);
        System.out.println(Arrays.toString(actual));
    }
}
