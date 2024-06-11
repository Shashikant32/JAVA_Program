import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        Solution s = new Solution();
        System.out.println(s.rowWithMaximumOnes(arr, n, m));
    }
}

class Solution {
    static int rowWithMaximumOnes(int arr[][], int n, int m) {
        int maxRowIndex = -1;
        int maxOnes = -1;
        
        for (int i = 0; i < n; i++) {
            int firstOneIndex = findFirstOneIndex(arr[i], m);
            if (firstOneIndex != -1 && (m - firstOneIndex) > maxOnes) {
                maxOnes = m - firstOneIndex;
                maxRowIndex = i;
            }
        }
        
        return maxRowIndex;
    }

    static int findFirstOneIndex(int[] row, int m) {
        int e = 0;
        int s = m - 1;
        int result = -1;
        
        while (e <= s) {
            int mid = e + (s - e) / 2;
            if (row[mid] == 1) {
                result = mid;
                s = mid - 1; 
            } else {
                e = mid + 1;
            }
        }
        
        return result;
    }
}
