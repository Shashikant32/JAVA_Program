import java.util.*;

class Solution {
    public static long countRectangles(int m, int n) {
        long horWays = (long) (m + 1) * m / 2;
        long verWays = (long) (n + 1) * n / 2;
        return horWays * verWays;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        long ans = Solution.countRectangles(m, n);
        System.out.println(ans);
    }
}
