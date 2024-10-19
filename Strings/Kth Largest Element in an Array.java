import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        
        int n = input.nextInt();
        int k = input.nextInt();
        int nums[] = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = input.nextInt();
        }
        Solution obj = new Solution();

        System.out.println(obj.solve(nums, k));
    }
}

class Solution {
    
    public int solve(int nums[], int k) {
        // The kth largest is the (n-k)th smallest in 0-based index
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    
    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }

        int pivotIndex = partition(nums, left, right);
        
        if (k == pivotIndex) {
            return nums[k];
        } else if (k < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, k);
        } else {
            return quickSelect(nums, pivotIndex + 1, right, k);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        
        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
