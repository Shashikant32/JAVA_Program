import java.io.*;
import java.util.*;

class Solution {
    void mazePathJumps(int n, int m) {
        findPaths(0, 0, n, m, "");
    }

    private void findPaths(int row, int col, int n, int m, String path) {
        if (row == n - 1 && col == m - 1) {
            System.out.println(path);
            return;
        }

        for (int hJump = 1; col + hJump < m; hJump++) {
            findPaths(row, col + hJump, n, m, path + "h" + hJump);
        }

        for (int vJump = 1; row + vJump < n; vJump++) {
            findPaths(row + vJump, col, n, m, path + "v" + vJump);
        }

        for (int dJump = 1; row + dJump < n && col + dJump < m; dJump++) {
            findPaths(row + dJump, col + dJump, n, m, path + "d" + dJump);
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        Solution obj = new Solution();
        obj.mazePathJumps(n, m);
    }
}
