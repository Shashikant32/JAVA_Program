import java.io.*;
import java.util.*;

public class Main {
    public static ArrayList<String> allPossiblePaths(int n, int m) {
        ArrayList<String> ans = new ArrayList<>(); 
        helper(1, 1, n, m, "", ans);
        return ans;
    }

    static void helper(int n, int m, int i, int j, String path, ArrayList<String> ans) {
        if (n == i && m == j) {
            ans.add(path);
            return;
        }
        if (n > i || m > j) {
            return;
        }
        // horizontal
        helper(n, m + 1, i, j, path + "h1", ans);
        helper(n, m + 2, i, j, path + "h2", ans);

        // vertical
        helper(n + 1, m, i, j, path + "v1", ans);
        helper(n + 2, m, i, j, path + "v2", ans);

        // diagonal
        helper(n + 1, m + 1, i, j, path + "d1", ans);
        helper(n + 2, m + 2, i, j, path + "d2", ans);
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in); 
        int n = input.nextInt();
        int m = input.nextInt();
        ArrayList<String> result = allPossiblePaths(n, m);
        Collections.sort(result);
        for (String str : result) {
            System.out.println(str);
        }
    }
}
