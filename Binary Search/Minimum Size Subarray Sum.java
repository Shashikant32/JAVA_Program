import java.util.Scanner;

class Solution {
    static int findLengthOfSmallestSubarray(int[] a, int K) {
        int n = a.length;
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        
        for (int right = 0; right < n; right++) {
            sum += a[right];
            
            while (sum >= K) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= a[left];
                left++;
            }
        }
        
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}

public class Main { 
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
        int K = keyboard.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = keyboard.nextInt();
        }
        keyboard.close();
        System.out.println(Solution.findLengthOfSmallestSubarray(a, K));
    }
}
