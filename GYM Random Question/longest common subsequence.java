import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        String[] aStr = br.readLine().trim().split(" ");
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(aStr[i]);
        }

        int m = Integer.parseInt(br.readLine().trim());
        String[] bStr = br.readLine().trim().split(" ");
        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(bStr[i]);
        }

        int lcsLength = longestCommonSubsequence(A, B, n, m);

        System.out.println(lcsLength);
    }

    private static int longestCommonSubsequence(int[] A, int[] B, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // Characters match
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // Take the maximum
                }
            }
        }

        return dp[n][m];
    }
}
