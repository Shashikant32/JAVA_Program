import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            
            Solution s = new Solution();
            System.out.println(s.twoEqualSubsets(arr));
        }
        
        sc.close();
    }
}

class Solution {
    public String twoEqualSubsets(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        
        if (totalSum % 2 != 0) {
            return "false";
        }
        
        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; 
        
        for (int num : arr) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        
        if (dp[target]) {
            return "true";
        } else {
            return "false";
        }
    }
}
