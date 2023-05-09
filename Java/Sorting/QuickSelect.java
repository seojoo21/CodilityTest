package Sorting;

import java.util.Random;

/**
 * How to get K'th largest element with QuickSelect Algorithm.
 * (for K'th smallest element, k=l-k (l=array's length))
 */
public class QuickSelect {

    public static void main(String[] args){
        int[] nums = { 3,2,3,1,2,4,5,5,6 };
        System.out.println(quickSelect(nums, 0, nums.length-1, 4));
    }

    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static int partition(int[] nums, int left, int right){
        int pivotIdx = left + new Random().nextInt(right-left+1);
        int pivot = nums[pivotIdx];
        swap(nums, pivotIdx, right);
        int idx = left;
        for (int i = left; i < right; i++) {
            if (nums[i] > pivot) {
                swap(nums, idx, i);
                idx++;
            }
        }
        swap(nums, idx, right);
        return idx;
    }

    public static int quickSelect(int[] nums, int left, int right, int k){
        int pivot = partition(nums, left, right);

        if(k-1 == pivot){
            return nums[pivot];
        }else if(k-1 < pivot){
            return quickSelect(nums, left, pivot-1, k);
        }else{
            return quickSelect(nums, pivot+1, right, k);
        }
    }
}
