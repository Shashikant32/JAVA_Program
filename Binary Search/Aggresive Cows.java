import java.io.*;
import java.util.*;

class Solution {
    public static int aggressiveCows(int[] stalls, int cows) {
        Arrays.sort(stalls);
        
        int low = 1; 
        int high = stalls[stalls.length - 1] - stalls[0]; 
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlaceCows(stalls, cows, mid)) {
                result = mid; 
                low = mid + 1;
            } else {
                high = mid - 1; 
            }
        }
        
        return result;
    }

    private static boolean canPlaceCows(int[] stalls, int cows, int minDist) {
        int count = 1; 
        int lastPlacedCow = stalls[0];
        
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPlacedCow >= minDist) {
                count++;
                lastPlacedCow = stalls[i];
                if (count == cows) {
                    return true;
                }
            }
        }
        
        return false;
    }
}

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        
        Solution obj = new Solution();
        System.out.println(obj.aggressiveCows(nums, k));
    }
}
