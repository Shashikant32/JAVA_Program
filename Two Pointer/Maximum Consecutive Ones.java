import java.io.*;
import java.util.*;

class Solution {
    public static int maxConsecutiveOnes(int[] arr, int n) {
        int maxCount = 0;  
        int currentCount = 0;  
        
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                currentCount++; 
            } else {
                maxCount = Math.max(maxCount, currentCount); 
                currentCount = 0;
            }
        }
        
        maxCount = Math.max(maxCount, currentCount);
        
        return maxCount;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // Read the size of the array
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();  // Read the array elements
        }
        Solution obj = new Solution();
        System.out.println(obj.maxConsecutiveOnes(arr, n));  // Print the result
    }
}
