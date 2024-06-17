import java.util.*;

class Solution {
    public static int solve(int n, int m, int[] arr) {
        int low = 1; 
        int high = Arrays.stream(arr).max().getAsInt(); 
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            long totalOperations = 0;
            for (int num : arr) {
                if (num > mid) {
                    totalOperations += (num - 1) / mid; // Ceil(num / mid) - 1
                    if (totalOperations > m) break;
                }
            }
            
            if (totalOperations <= m) {
                high = mid - 1; 
            } else {
                low = mid + 1; 
            }
        }
        
        return low;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        
        System.out.println(Solution.solve(n, m, arr));
    }
}
