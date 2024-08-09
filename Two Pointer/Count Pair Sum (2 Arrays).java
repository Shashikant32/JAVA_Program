import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int arr1[] = new int[m];
        int arr2[] = new int[n];
        for (int i = 0; i < m; i++) {
            arr1[i] = input.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = input.nextInt();
        }
        int x = input.nextInt();
        Solution obj = new Solution();
        System.out.println(obj.countElements(arr1, arr2, m, n, x));
    }
}

class Solution {
    public int countElements(int[] arr1, int[] arr2, int m, int n, int x) {
        int count = 0;
        int i = 0; 
        int j = n - 1; 
        
        while (i < m && j >= 0) {
            int sum = arr1[i] + arr2[j];
            
            if (sum == x) {
                count++;
                i++;
                j--;
            } else if (sum < x) {
                i++;
            } else {
                j--;
            }
        }
        
        return count;
    }
}
