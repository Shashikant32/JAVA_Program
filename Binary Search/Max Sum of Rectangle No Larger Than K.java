import java.util.*;

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxSum = Integer.MIN_VALUE;
        
        for (int startCol = 0; startCol < n; startCol++) {
            int[] rowSum = new int[m];
            
            for (int endCol = startCol; endCol < n; endCol++) {
                for (int row = 0; row < m; row++) {
                    rowSum[row] += matrix[row][endCol];
                }
                
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0); 
                
                int currentSum = 0;
                
                for (int sum : rowSum) {
                    currentSum += sum;
                    
                    Integer ceiling = set.ceiling(currentSum - k);
                    if (ceiling != null) {
                        maxSum = Math.max(maxSum, currentSum - ceiling);
                    }
                    
                    set.add(currentSum);
                }
            }
        }
        
        return maxSum;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        
        int k = sc.nextInt();
        
        Solution sol = new Solution();
        int maxSum = sol.maxSumSubmatrix(matrix, k);
        System.out.println(maxSum);
    }
}
