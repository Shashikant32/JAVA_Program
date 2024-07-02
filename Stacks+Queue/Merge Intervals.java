import java.util.*;

class Solution {
    public void merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];
        
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            
            if (currentInterval[1] >= interval[0]) {
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            } else {
                result.add(currentInterval);
                currentInterval = interval;
            }
        }
        
        result.add(currentInterval);
        
        for (int[] merged : result) {
            System.out.println(merged[0] + " " + merged[1]);
        }
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[][] A = new int[m][2];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        
        Solution obj = new Solution();
        obj.merge(A);
    }
}
