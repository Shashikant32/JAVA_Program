import java.util.*;
import java.io.*;

public class Main {
    public static int[][] nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        // Distance matrix initialized to a large number
        int[][] dist = new int[n][m];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        // Queue for BFS
        Queue<int[]> queue = new LinkedList<>();
        
        // Initialize the queue with all cells having value 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[] {i, j});
                    dist[i][j] = 0; // Distance to itself is 0
                }
            }
        }
        
        // Directions for moving in 4 possible ways (up, down, left, right)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            // Explore all 4 directions
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                
                // Check bounds
                if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                    // If moving to new cell offers a shorter distance
                    if (dist[newX][newY] > dist[x][y] + 1) {
                        dist[newX][newY] = dist[x][y] + 1;
                        queue.offer(new int[] {newX, newY});
                    }
                }
            }
        }
        
        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().trim().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] grid = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            String[] S = br.readLine().trim().split(" ");
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(S[j]);
            }
        }
        
        int[][] ans = nearest(grid);
        
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
