import java.util.*;

public class Main {

    static int countAllPathHelper(int i, int j, int n, int m, boolean[][] visited) {
        if (i == n - 1 && j == m - 1) {
            return 1;
        }

        visited[i][j] = true;

        int[] rowMove = {0, 1, 0, -1, 1, 1, -1, -1}; // row direction for 8 moves
        int[] colMove = {1, 0, -1, 0, 1, -1, 1, -1}; // column direction for 8 moves

        int count = 0;

        for (int k = 0; k < 8; k++) {
            int newRow = i + rowMove[k];
            int newCol = j + colMove[k];

            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !visited[newRow][newCol]) {
                count += countAllPathHelper(newRow, newCol, n, m, visited);
            }
        }

        visited[i][j] = false;

        return count;
    }

    static int countAllPath(int n, int m) {
        boolean[][] visited = new boolean[n][m];

        return countAllPathHelper(0, 0, n, m, visited);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        System.out.println(countAllPath(n, m));
    }
}
