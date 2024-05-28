import java.util.*;

class Solution {
    public int solve(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return 0;
        }

        int m = heights.length;
        int n = heights[0].length;
        int volume = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{i, 0, heights[i][0]});
            pq.offer(new int[]{i, n - 1, heights[i][n - 1]});
            heights[i][0] = heights[i][n - 1] = -1; 
        }

        for (int j = 1; j < n - 1; j++) {
            pq.offer(new int[]{0, j, heights[0][j]});
            pq.offer(new int[]{m - 1, j, heights[m - 1][j]});
            heights[0][j] = heights[m - 1][j] = -1; 
        }

        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int row = cell[0];
            int col = cell[1];
            int h = cell[2];

            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && heights[newRow][newCol] != -1) {
                    int newH = Math.max(h, heights[newRow][newCol]);
                    volume += newH - heights[newRow][newCol];
                    pq.offer(new int[]{newRow, newCol, newH});
                    heights[newRow][newCol] = -1; 
                }
            }
        }

        return volume;
    }
}

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int m, n;
        m = sc.nextInt();
        n = sc.nextInt();

        int[][] heights = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                heights[i][j] = sc.nextInt();
        }

        Solution obj = new Solution();
        System.out.println(obj.solve(heights));
        sc.close();
    }
}
