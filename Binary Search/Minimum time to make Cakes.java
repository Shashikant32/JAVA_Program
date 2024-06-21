import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(); 
            int m = sc.nextInt();
            int k = sc.nextInt(); 
            
            int[] bloomDay = new int[n];
            for (int i = 0; i < n; i++) {
                bloomDay[i] = sc.nextInt();
            }
            
            Solution solution = new Solution();
            int result = solution.minDays(bloomDay, m, k);
            System.out.println(result);
        }
        sc.close();
    }
}

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (m * k > n) {
            return -1; 
        }
        
        int low = 1;
        int high = Arrays.stream(bloomDay).max().getAsInt();
        int result = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (isPossible(bloomDay, m, k, mid)) {
                result = mid;
                high = mid - 1; 
            } else {
                low = mid + 1; 
            }
        }
        
        return result;
    }
    
    private boolean isPossible(int[] bloomDay, int m, int k, int days) {
        int count = 0;
        int consecutive = 0;
        
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= days) {
                consecutive++;
                if (consecutive == k) {
                    count++;
                    consecutive = 0;
                }
            } else {
                consecutive = 0;
            }
        }
        
        return count >= m;
    }
}
