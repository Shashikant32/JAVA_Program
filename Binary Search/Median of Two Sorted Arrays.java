import java.util.Scanner;

class Solution {
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        // Ensure nums1 is the smaller array
        if (n > m) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int imin = 0, imax = n, halfLen = (n + m + 1) / 2;
        while (imin <= imax) {
            int i = (imin + imax) / 2;
            int j = halfLen - i;
            if (i < n && nums2[j - 1] > nums1[i]) {
                imin = i + 1; // i is too small
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
                imax = i - 1; // i is too big
            } else { // i is perfect
                int maxOfLeft;
                if (i == 0) { maxOfLeft = nums2[j - 1]; }
                else if (j == 0) { maxOfLeft = nums1[i - 1]; }
                else { maxOfLeft = Math.max(nums1[i - 1], nums2[j - 1]); }
                if ((n + m) % 2 == 1) { return maxOfLeft; }

                int minOfRight;
                if (i == n) { minOfRight = nums2[j]; }
                else if (j == m) { minOfRight = nums1[i]; }
                else { minOfRight = Math.min(nums1[i], nums2[j]); }

                return (maxOfLeft + minOfRight) / 2.0;
            }
        }
        return 0.0;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[] nums1 = new int[n];
        int[] nums2 = new int[m];

        for (int i = 0; i < n; i++) {
            nums1[i] = scn.nextInt();
        }

        for (int i = 0; i < m; i++) {
            nums2[i] = scn.nextInt();
        }

        Solution sol = new Solution();
        double ans = sol.findMedianSortedArrays(nums1, nums2);

        System.out.println(ans);

        scn.close();
    }
}
