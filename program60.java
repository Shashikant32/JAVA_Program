import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        // Majority Element
        int candidate = findCandidate(nums);
        int count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
        return (count > nums.length / 2) ? candidate : -1;
    }
    
    private int findCandidate(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = nums[i];
                    count = 1;
                }
            }
        }
        return candidate;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Solution solution = new Solution();
        int majorityElement = solution.majorityElement(arr);
        System.out.println(majorityElement);
        scanner.close();
    }
}
