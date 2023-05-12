package Sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void main(String[] args){
        int[] nums = { 3,2,3,1,2,4,5,5,6 };
        quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums, int left, int right){
        if(left >= right) return;

        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot-1);
        quickSort(nums, pivot+1, right);
    }

    public static int partition(int[] nums, int left, int right){
        int pivotIdx = left + new Random().nextInt(right-left+1);
        int pivot = nums[pivotIdx];
        swap(nums, pivotIdx, right);
        int idx = left;
        for(int i=left; i<right; i++){
            if(nums[i] < pivot){
                swap(nums, i, idx);
                idx++;
            }
        }
        swap(nums, idx, right);
        return idx;
    }

    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
