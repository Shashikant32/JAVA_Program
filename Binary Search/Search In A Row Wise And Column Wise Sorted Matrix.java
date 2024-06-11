import java.util.*;

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t--;
            int n = sc.nextInt();
            int x = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Pair p = search(arr, x);
            System.out.println(p.x + " " + p.y);
        }
        sc.close();
    }

    public static Pair search(int[][] matrix, int x) {
        int n = matrix.length;
        int row = 0;
        int col = n - 1;

        while (row < n && col >= 0) {
            if (matrix[row][col] == x) {
                return new Pair(row, col);
            } else if (matrix[row][col] > x) {
                col--;
            } else {
                row++;
            }
        }

        return new Pair(-1, -1); 
    }
}
