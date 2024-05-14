import java.util.*;

class Solution {
    public int maxAmount(int[] a) {
        int n = a.length;
        if (n == 0) return 0;
        if (n == 1) return a[0];
        
        int[] dp = new int[n];
        
        // Base cases
        dp[0] = a[0];
        dp[1] = Math.max(a[0], a[1]);
        
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(a[i] + dp[i - 2], dp[i - 1]);
        }
        
        return dp[n - 1]; 
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        Solution obj = new Solution();
        System.out.println(obj.maxAmount(a));
        sc.close();
    }
}
