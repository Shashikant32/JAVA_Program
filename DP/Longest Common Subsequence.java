import java.util.*;

class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int p = sc.nextInt(); // Take size of the first string as input
        int q = sc.nextInt(); // Take size of the second string as input
        
        String a = sc.next(); // Take the first string as input
        String b = sc.next(); // Take the second string as input
        
        Solution obj = new Solution();
        
        System.out.println(obj.lcs(p, q, a, b)); // Print the length of the longest common subsequence

        sc.close();
    }
}

class Solution {
    static int lcs(int x, int y, String a, String b) {
        int[][] dp = new int[x + 1][y + 1];

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[x][y];
    }
}
