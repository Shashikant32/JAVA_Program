import java.io.*;
import java.util.*;

class Main {
    public static ArrayList<Integer> sumOfAllSubSquares(int[][] matrix, int k) {
        int n = matrix.length;
        ArrayList<Integer> result = new ArrayList<>();
        
        int[][] prefixSum = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = matrix[i - 1][j - 1] 
                                + prefixSum[i - 1][j] 
                                + prefixSum[i][j - 1] 
                                - prefixSum[i - 1][j - 1];
            }
        }
        
        for (int i = k; i <= n; i++) {
            for (int j = k; j <= n; j++) {
                int sum = prefixSum[i][j] 
                        - prefixSum[i - k][j] 
                        - prefixSum[i][j - k] 
                        + prefixSum[i - k][j - k];
                result.add(sum);
            }
        }
        
        return result;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] nums = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        
        ArrayList<Integer> ans = sumOfAllSubSquares(nums, k);
        for(int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
