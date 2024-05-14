import java.util.*;

class Solution {
    public static int solve(int[] arr, int k) {
        int maxSum = Integer.MIN_VALUE;
        int windowSum = 0;

        // Calculate sum of first window of size k
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        // Update maxSum with sum of first window
        maxSum = Math.max(maxSum, windowSum);

        
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Solution.solve(arr, k));
    }
}
