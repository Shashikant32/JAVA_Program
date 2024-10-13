import java.io.*;
import java.util.*;

class Solution {
    public boolean targetSum(int[] nums, int target) {
        return canSum(0, nums, 0, target);
    }

    private boolean canSum(int start, int[] nums, int sum, int target) {
        if (sum == target) {
            return true;
        }
        if (start >= nums.length || sum > target) {
            return false;
        }
        if (canSum(start + 1, nums, sum + nums[start], target)) {
            return true;
        }
        return canSum(start + 1, nums, sum, target);
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        Solution obj = new Solution();
        System.out.println(obj.targetSum(arr, target));
        sc.close();
    }
}
