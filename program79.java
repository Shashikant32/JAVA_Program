import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Diagonal Traversal of a Matrix
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                mat[i][j] = sc.nextInt();
        }
        sc.close();
        ArrayList<Integer> res = diagonalTraversal(mat, n);
        for (Integer x : res)
            System.out.print(x + " ");
    }

    public static ArrayList<Integer> diagonalTraversal(int[][] mat, int n) {
        ArrayList<Integer> result = new ArrayList<>();
         for (int i = n - 1; i >= 0; i--) {
            int row = 0;
            int col = i;
            while (col < n) {
                result.add(mat[row++][col++]);
            }
        }
        for (int i = 1; i < n; i++) {
            int row = i;
            int col = 0;
            while (row < n) {
               // System.out.print(mat[row++][col++] + " ");
               result.add(mat[row++][col++]);
            }
        }
        return result;
    }
}