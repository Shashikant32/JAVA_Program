import java.util.*;

class Solution {
    public static long solve(int[] A, int B) {
        long maxWeight = 0;
        long sumWeights = 0;
        
       
        for (int weight : A) {
            maxWeight = Math.max(maxWeight, weight);
            sumWeights += weight;
        }
        
        if (B >= A.length) {
            return maxWeight;
        }
        
        long s = maxWeight;
        long e = sumWeights;
        long ans = -1;
        
        while (s <= e) {
            long mid = s + (e - s) / 2;
            if (isPossible(A, B, mid)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        
        return s;
    }

    private static boolean isPossible(int[] A, int B, long capacity) {
        int days = 1;
        long currentLoad = 0;
        
        for (int weight : A) {
            if (currentLoad + weight > capacity) {
                days++;
                currentLoad = 0;
            }
            currentLoad += weight;
            if (days > B) {
                return false;
            }
        }
        
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        
        int B = sc.nextInt();
        System.out.println(Solution.solve(A, B));
    }
}
