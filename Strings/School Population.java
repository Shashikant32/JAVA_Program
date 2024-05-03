import java.util.*;

class Solution {
    public int[] population(int[] nums) {
        int n = nums.length;
        int carry = 1; 
        for (int i = n - 1; i >= 0 && carry > 0; i--) {
            int sum = nums[i] + carry;
            nums[i] = sum % 10; 
            carry = sum / 10; 
        }
        
        if (carry > 0) {
            int[] result = new int[n + 1];
            result[0] = carry;
            for (int i = 1; i <= n; i++) {
                result[i] = nums[i - 1];
            }
            return result;
        }
        return nums;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        Solution obj = new Solution();
        int[] result = obj.population(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
