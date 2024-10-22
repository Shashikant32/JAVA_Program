import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int k = sc.nextInt();
        sc.close();
        System.out.println(findKthLargest(arr, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }
        
        Random random = new Random();
        int pivotIndex = left + random.nextInt(right - left + 1);
        
        // Move the pivot to the end
        int pivotValue = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        
        // Partitioning
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }
        
        // Move the pivot back to its final place
        swap(nums, storeIndex, right);
        
        // Now, storeIndex is the pivot index
        if (storeIndex == k) {
            return nums[storeIndex];
        } else if (storeIndex < k) {
            return quickSelect(nums, storeIndex + 1, right, k);
        } else {
            return quickSelect(nums, left, storeIndex - 1, k);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
