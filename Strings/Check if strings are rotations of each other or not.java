import java.util.*;

class Solution {
    static int isCyclicRotation(String p, String q) {
        if (p.length() != q.length()) {
            return 0;
        }

        String concatenated = p + p;

        if (concatenated.contains(q)) {
            return 1;
        } else {
            return 0;
        }
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        String p = sc.next();
        String q = sc.next();
        int ans = Solution.isCyclicRotation(p, q);
        System.out.println(ans);
    }
}
