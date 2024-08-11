import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        sc.close();
        System.out.println(numEnclaves(grid));
    }

    public static int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        // Directions for moving in 4 directions
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // BFS to mark all cells connected to boundary
        Queue<int[]> queue = new LinkedList<>();

        // Enqueue all boundary land cells
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1 && !visited[i][0]) queue.offer(new int[]{i, 0});
            if (grid[i][n-1] == 1 && !visited[i][n-1]) queue.offer(new int[]{i, n-1});
        }
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1 && !visited[0][j]) queue.offer(new int[]{0, j});
            if (grid[m-1][j] == 1 && !visited[m-1][j]) queue.offer(new int[]{m-1, j});
        }

        // Perform BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];
            
            if (visited[x][y]) continue;
            visited[x][y] = true;
            
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1 && !visited[newX][newY]) {
                    queue.offer(new int[]{newX, newY});
                }
            }
        }

        // Count the land cells that are not visited
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }
}
