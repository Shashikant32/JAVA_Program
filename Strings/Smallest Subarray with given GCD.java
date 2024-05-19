import java.io.*;
import java.util.*;

class Main {

    static int findSmallestSubarr(int arr[], int n, int k) {
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int currentGCD = 0;
            for (int j = i; j < n; j++) {
                currentGCD = gcd(currentGCD, arr[j]);
                if (currentGCD == k) {
                    minLength = Math.min(minLength, j - i + 1);
                    break; 
                }
                if (currentGCD < k) break; 
            }
        }

        return (minLength == Integer.MAX_VALUE) ? -1 : minLength;
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(findSmallestSubarr(nums, n, k));
    }
}
