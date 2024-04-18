import java.io.*;
import java.util.*;

class Solution {
        public boolean isToeplitzMatrix(int[][] matrix, int m, int n) {
            //Toeplitz Matrix
         m = matrix.length;
         n = matrix[0].length;

        // Check diagonals starting from the top row
        for (int i = 0; i < m - 1; i++) {
            if (!checkDiagonal(matrix, i, 0)) {
                return false;
            }
        }

        // Check diagonals starting from the left column
        for (int j = 1; j < n - 1; j++) {
            if (!checkDiagonal(matrix, 0, j)) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkDiagonal(int[][] matrix, int startRow, int startCol) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int value = matrix[startRow][startCol];
        
        // Iterate along the diagonal
        for (int i = startRow + 1, j = startCol + 1; i < m && j < n; i++, j++) {
            if (matrix[i][j] != value) {
                return false;
            }
        }
        
        return true;
    }
}

public class Main {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] A = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        Solution Obj = new Solution();
        boolean ans = Obj.isToeplitzMatrix(A,m,n);
        System.out.println(ans);
    }
}