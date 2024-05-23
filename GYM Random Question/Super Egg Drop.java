import java.util.*;

class Solution {
    public static int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];

        for (int j = 1; j <= N; j++) {
            dp[1][j] = j;
        }

        for (int i = 2; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <= j; x++) {
                    int broken = dp[i - 1][x - 1];
                    int unbroken = dp[i][j - x];
                    int moves = 1 + Math.max(broken, unbroken);
                    dp[i][j] = Math.min(dp[i][j], moves);
                }
            }
        }

        return dp[K][N];
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        sc.close();
        System.out.println(Solution.superEggDrop(k, n));
    }
}
