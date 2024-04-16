import java.util.*;

public class Main {

    public static int[] SumArrayExpectSelf(int[] nums, int n) {
        //Sum of Array Except Self
        
       int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

         n = nums.length;
        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            output[i] = totalSum - nums[i];
        }

        return output;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] nums = new int[n];

        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] Ans = SumArrayExpectSelf(nums, n);

        for(int a : Ans)
            System.out.print(a + " ");
    }
}
