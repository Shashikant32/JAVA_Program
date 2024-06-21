import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int m = sc.nextInt(); 
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        Solution solution = new Solution();
        int result = solution.splitArray(arr, m);
        System.out.println(result);
        
        sc.close();
    }
}

class Solution {

    public static int splitArray(int[] arr, int m) {
        int low = 0;
        int high = 0;
        for (int num : arr) {
            low = Math.max(low, num);
            high += num;
        }
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isPossible(arr, m, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low; 
    }
    
    private static boolean isPossible(int[] arr, int m, int maxSum) {
        int count = 1; 
        int sum = 0;
        
        for (int num : arr) {
            sum += num;
            if (sum > maxSum) {
                count++; 
                sum = num; 
                if (count > m) {
                    return false; 
                }
            }
        }
        
        return true; 
    }
}
