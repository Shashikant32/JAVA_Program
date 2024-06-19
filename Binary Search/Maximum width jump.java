import java.util.*;

class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int maxRampWidth = 0;
        
        for (int j = 0; j < nums.length; j++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[j]) {
                stack.push(j);
            }
        }
        
        for (int j = nums.length - 1; j >= 0; j--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                int i = stack.pop();
                maxRampWidth = Math.max(maxRampWidth, j - i);
            }
        }
        
        return maxRampWidth;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Solution obj = new Solution();
        System.out.println(obj.maxWidthRamp(nums));
        sc.close();
    }
}
