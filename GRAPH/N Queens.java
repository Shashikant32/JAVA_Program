import java.util.*;

public class Main {
    
    public static boolean isSafe(int[][] grid, int r, int c, int n) {
        // Check column
        for (int i = 0; i < r; i++) {
            if (grid[i][c] == 1) return false;
        }

        // Check upper-left diagonal
        int i = r - 1, j = c - 1;
        while (i >= 0 && j >= 0) {
            if (grid[i][j] == 1) return false;
            i--;
            j--;
        }

        // Check upper-right diagonal
        i = r - 1; j = c + 1;
        while (i >= 0 && j < n) {
            if (grid[i][j] == 1) return false;
            i--;
            j++;
        }

        return true;
    }

    public static int nQueen(int[][] grid, int r, int n) {
        if (r == n) {
            return 1;
        }
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (isSafe(grid, r, i, n)) {
                grid[r][i] = 1;
                count += nQueen(grid, r + 1, n);
                grid[r][i] = 0;
            }
        }
        return count;
    }

    public static int totalNQueens(int n) {
        int[][] grid = new int[n][n];
        return nQueen(grid, 0, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(totalNQueens(n));
        sc.close();
    }
}
