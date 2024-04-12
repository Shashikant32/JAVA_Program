import java.io.*;
import java.util.*;

class Solution {
    // Max Consecutive Ones
    static int getMaxLength(int arr[], int n)
    {
        int maxCount = 0;
        int currentCount = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                currentCount++;
                maxCount = Math.max(maxCount, currentCount);
            } else {
                currentCount = 0;
            }
        }
        
        return maxCount;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr1[] = new int[n];
        for(int i=0;i<n;i++)
            arr1[i] = sc.nextInt();
        Solution Obj = new Solution();
        int result = Obj.getMaxLength(arr1,n);
        System.out.print(result);
    }
}