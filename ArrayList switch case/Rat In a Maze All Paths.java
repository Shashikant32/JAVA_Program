import java.util.*;

class Solution {
    private static final int[] dRow = {-1, 1, 0, 0};
    private static final int[] dCol = {0, 0, -1, 1};

    public static ArrayList<ArrayList<Integer>> ratInAMaze(int[][] maze, int n) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        int[][] solution = new int[n][n];
        findPaths(maze, solution, 0, 0, paths, n);
        return paths;
    }

    private static void findPaths(int[][] maze, int[][] solution, int x, int y, ArrayList<ArrayList<Integer>> paths, int n) {
        if (x == n - 1 && y == n - 1) {
            solution[x][y] = 1;
            ArrayList<Integer> path = new ArrayList<>();
            for (int[] row : solution) {
                for (int cell : row) {
                    path.add(cell);
                }
            }
            paths.add(path);
            solution[x][y] = 0;
            return;
        }

        if (!isSafe(maze, solution, x, y, n)) {
            return;
        }

        solution[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int newRow = x + dRow[i];
            int newCol = y + dCol[i];
            findPaths(maze, solution, newRow, newCol, paths, n);
        }
        solution[x][y] = 0;
    }

    private static boolean isSafe(int[][] maze, int[][] solution, int x, int y, int n) {
        return (x >= 0 && x < n && y >= 0 && y < n && maze[x][y] == 1 && solution[x][y] == 0);
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] maze = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        
        ArrayList<ArrayList<Integer>> ans = Solution.ratInAMaze(maze, n);
        for (ArrayList<Integer> path : ans) {
            for (Integer cell : path) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
