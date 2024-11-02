import java.io.*;
import java.util.*;

class Solution {
    public int[] recentCalls(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        int left = 0;

        for (int right = 0; right < n; right++) {
            while (arr[right] - arr[left] > 3000) {
                left++;
            }
            result[right] = right - left + 1;
        }
        
        return result;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        Solution Obj = new Solution();
        int[] ans = Obj.recentCalls(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
