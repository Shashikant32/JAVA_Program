import java.util.*;

class Solution {
    public int minSems(int n, int[][] dependencies, int k) {
        int m = 1 << n; 
        int[] dp = new int[m];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; 

        int[] prerequisites = new int[n + 1];
        for (int[] dep : dependencies) {
            prerequisites[dep[1]] |= (1 << (dep[0] - 1)); // Store prerequisites in bitmask
        }

        for (int mask = 0; mask < m; mask++) {
            if (dp[mask] == Integer.MAX_VALUE) continue;

            List<Integer> availableCourses = new ArrayList<>();
            for (int course = 1; course <= n; course++) {
                if ((mask & prerequisites[course]) == prerequisites[course] && (mask & (1 << (course - 1))) == 0) {
                    availableCourses.add(course);
                }
            }

            int size = availableCourses.size();
            for (int i = 1; i < (1 << size); i++) {
                if (Integer.bitCount(i) > k) continue; // Can't take more than k courses

                int nextMask = mask;
                for (int j = 0; j < size; j++) {
                    if ((i & (1 << j)) != 0) {
                        nextMask |= (1 << (availableCourses.get(j) - 1)); // Mark course as taken
                    }
                }
                dp[nextMask] = Math.min(dp[nextMask], dp[mask] + 1); 
            }
        }

        return dp[m - 1]; 
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int arr[][] = new int[m][2];
        for (int i = 0; i < m; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        sc.close();
        Solution obj = new Solution();
        System.out.println(obj.minSems(n, arr, k));
    }
}
