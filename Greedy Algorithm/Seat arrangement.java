import java.util.*;

class Solution {
    public int seat(String s) {
        int MOD = 10000003;
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'x') {
                indices.add(i);
            }
        }

        int n = indices.size();
        if (n <= 1) {
            return 0;
        }

        Collections.sort(indices);
        int median = indices.get(n / 2);

        int moves = 0;
        for (int i = 0; i < n; i++) {
            moves = (moves + Math.abs(indices.get(i) - (median - n / 2 + i))) % MOD;
        }

        return moves;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        Solution obj = new Solution();
        System.out.println(obj.seat(str));
    }
}
