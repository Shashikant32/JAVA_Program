import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int d = sc.nextInt();
        boolean ans = Solution.isPossibleToSurvive(n, x, d);
        if(ans) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}

class Solution {
    static boolean isPossibleToSurvive(int n, int x, int d ) {
        long totalFood = (long) n * d;
        return totalFood >= (long) x * d;
    }
}
