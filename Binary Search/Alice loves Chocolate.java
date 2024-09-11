import java.util.*;

class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t > 0) {
                int n = sc.nextInt();
                int k = sc.nextInt();
                int[] A = new int[n];
                for (int i = 0; i < n; i++) {
                    A[i] = sc.nextInt();
                }
                Solution ob = new Solution();
                int ans = ob.minEatingSpeed(A, n, k);
                System.out.println(ans);
                t--;
            }
        }
    }
}

class Solution {
    public int minEatingSpeed(int[] piles, int n, int K) {
        int low = 1;
        int high = 0;
        
        for (int pile : piles) {
            if (pile > high) {
                high = pile;
            }
        }
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canFinish(piles, mid, K)) {
                high = mid; 
            } else {
                low = mid + 1; 
            }
        }
        
        return low;
    }

    private boolean canFinish(int[] piles, int speed, int hours) {
        int totalHours = 0;
        for (int pile : piles) {
            totalHours += (pile + speed - 1) / speed; // Equivalent to ceil(pile / speed)
            if (totalHours > hours) {
                return false;
            }
        }
        return totalHours <= hours;
    }
}
