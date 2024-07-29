import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = input.nextInt();
        }
        Solution ob = new Solution();
        long ans = ob.maxSubarraySum(a, n);
        System.out.println(ans);
    }
}

class Solution {
    public long maxSubarraySum(int[] a, int n) {
        if (n == 0) {
            return 0;
        }
        
        long maxSoFar = a[0];
        long maxEndingHere = a[0];
        
        for (int i = 1; i < n; i++) {
            maxEndingHere = Math.max(a[i], maxEndingHere + a[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;
    }
}
