package Sorting;

import java.util.Random;

/**
 * How to get K'th largest element with QuickSelect Algorithm.
 * (for K'th smallest element, k=l-k (l=array's length))
 */
public class QuickSelect {

    public static void main(String[] args){
        int[] nums = { 69, 10, 30, 2, 16, 8, 31, 22 };
        System.out.println(quickSelect(nums, 0, nums.length-1, 3));
    }

    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static int partition(int[] nums, int left, int right){
        int pivot = left + new Random().nextInt(right-left+1);
        swap(nums, right, pivot);
        for(int i=left; i<right; i++){
            if(nums[i] > nums[right]){
                swap(nums, i, left);
                left++;
            }
        }
        swap(nums, left, right);
        return left;
    }

    public static int quickSelect(int[] nums, int left, int right, int k){
        int pivot = partition(nums, left, right);

        if(k == pivot){
            return nums[k];
        }else if(k < pivot){
            return quickSelect(nums, left, pivot-1, k);
        }else{
            return quickSelect(nums, pivot+1, right, k);
        }
    }
}
