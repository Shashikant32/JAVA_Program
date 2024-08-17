import java.util.*;

class Solution {
    public static int solve(List<List<Integer>> A) {
        if (A == null || A.size() == 0) {
            return 0;
        }
        
        A.sort((a, b) -> Integer.compare(a.get(1), b.get(1)));
        
        int count = 0;
        int lastEnd = Integer.MIN_VALUE;
        
        for (List<Integer> interval : A) {
            if (interval.get(0) > lastEnd) {
                count++;
                lastEnd = interval.get(1); 
            }
        }
        
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            List<Integer> interval = Arrays.asList(a, b);
            A.add(interval);
        }
        int ans = Solution.solve(A);
        System.out.println(ans);
    }
}
