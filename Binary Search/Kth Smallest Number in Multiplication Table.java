import java.io.*;
import java.util.*;


class Main {
	public static void main (String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        Solution ob = new Solution();
        
        System.out.println(ob.KthSmallest(m,n, k));
        
	}
}

class Solution {
    public int KthSmallest(int m, int n, int k) {
        int left = 1;
        int right = m * n;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = countLessEqual(mid, m, n);
            
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    private int countLessEqual(int x, int m, int n) {
        int count = 0;
        
        for (int i = 1; i <= m; i++) {
            count += Math.min(x / i, n);
        }
        
        return count;
    }
}