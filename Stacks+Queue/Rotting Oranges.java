import java.util.*;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        Solution obj = new Solution();
        System.out.println(obj.orangesRotting(arr));
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        
        int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
        int minutes = 0;
        
        while (!queue.isEmpty() && freshOranges > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                int x = point[0];
                int y = point[1];
                
                for (int[] dir : directions) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        queue.offer(new int[]{nx, ny});
                        freshOranges--;
                    }
                }
            }
            minutes++;
        }
        
        if (freshOranges > 0) {
            return -1;
        } else {
            return minutes; 
        }
    }
}
