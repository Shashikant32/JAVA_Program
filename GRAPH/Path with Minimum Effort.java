import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt(), columns = sc.nextInt();
        int[][] heights = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                heights[i][j] = sc.nextInt();
            }
        }
        sc.close();
        System.out.println(minimumEffortPath(heights));
    }

    public static int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] effort = new int[rows][cols];
        for (int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Priority queue to store cells with their current effort and position
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(Comparator.comparingInt(c -> c.effort));
        minHeap.add(new Cell(0, 0, 0)); // Starting from (0, 0) with 0 effort

        // Directions for moving up, down, left, right
        int[] directions = {-1, 1, 0, 0};
        int[] dcols = {0, 0, -1, 1};

        while (!minHeap.isEmpty()) {
            Cell current = minHeap.poll();
            int r = current.row;
            int c = current.col;
            int currentEffort = current.effort;

            // If we reach the bottom-right corner, return the effort
            if (r == rows - 1 && c == cols - 1) {
                return currentEffort;
            }

            // Explore all four directions
            for (int i = 0; i < 4; i++) {
                int newRow = r + directions[i];
                int newCol = c + dcols[i];
                
                // Check bounds and if we have found a better effort path
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    int newEffort = Math.max(currentEffort, Math.abs(heights[newRow][newCol] - heights[r][c]));
                    
                    // If this new effort is better, update and push to the queue
                    if (newEffort < effort[newRow][newCol]) {
                        effort[newRow][newCol] = newEffort;
                        minHeap.add(new Cell(newRow, newCol, newEffort));
                    }
                }
            }
        }

        return -1; // This line should never be reached
    }

    // Helper class to store cell information and effort
    static class Cell {
        int row;
        int col;
        int effort;

        Cell(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
    }
}
