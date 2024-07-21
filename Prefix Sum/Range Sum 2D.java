import java.util.*;

class Pair {
    int row1;
    int row2;
    int col1;
    int col2;
}

class Solution {

    public List<Integer> solve(int[][] matrix, Pair[] queries) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        // Step 1: Compute prefix sum array
        int[][] prefixSum = new int[n][m];
        
        // Initialize prefix sum array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prefixSum[i][j] = matrix[i][j];
                if (i > 0) prefixSum[i][j] += prefixSum[i - 1][j];
                if (j > 0) prefixSum[i][j] += prefixSum[i][j - 1];
                if (i > 0 && j > 0) prefixSum[i][j] -= prefixSum[i - 1][j - 1];
            }
        }
        
        // Step 2: Process each query
        List<Integer> result = new ArrayList<>();
        for (Pair query : queries) {
            int row1 = query.row1;
            int col1 = query.col1;
            int row2 = query.row2;
            int col2 = query.col2;
            
            int sum = prefixSum[row2][col2];
            if (row1 > 0) sum -= prefixSum[row1 - 1][col2];
            if (col1 > 0) sum -= prefixSum[row2][col1 - 1];
            if (row1 > 0 && col1 > 0) sum += prefixSum[row1 - 1][col1 - 1];
            
            result.add(sum);
        }
        
        return result;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read matrix dimensions
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        // Read the matrix
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        
        // Read number of queries
        int q = sc.nextInt();
        
        // Read each query
        Pair[] queries = new Pair[q];
        for (int i = 0; i < q; i++) {
            Pair p = new Pair();
            p.row1 = sc.nextInt();
            p.col1 = sc.nextInt();
            p.row2 = sc.nextInt();
            p.col2 = sc.nextInt();
            queries[i] = p;
        }
        
        // Solve the problem
        Solution obj = new Solution();
        List<Integer> result = obj.solve(matrix, queries);
        
        // Print the result
        for (int x : result) {
            System.out.println(x);
        }
        
        sc.close();
    }
}
