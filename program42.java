import java.util.Scanner;

public class Main {
    public static int maxSubarraySum(int[] nums) {
        //Finding the Maximum Subarray Sum
        int maxEnding = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEnding = Math.max(nums[i], maxEnding + nums[i]);
            max = Math.max(max, maxEnding);
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
        int[] nums = new int[n];
		if(n == 0) {
			System.out.println(0);
			return;
		}
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int result = maxSubarraySum(nums);
        System.out.println(result);
    }
}
