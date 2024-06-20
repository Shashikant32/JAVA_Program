import java.util.*;

class Solution {
    static double median(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        
        if (m > n) {
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        
        int left = 0, right = m, halfLen = (m + n + 1) / 2;
        
        while (left <= right) {
            int midA = (left + right) / 2;
            int midB = halfLen - midA;
            
            if (midA < m && B[midB - 1] > A[midA]) {
                left = midA + 1;
            } else if (midA > 0 && A[midA - 1] > B[midB]) {
                right = midA - 1; 
            } else {
                double maxLeft = 0;
                if (midA == 0) {
                    maxLeft = B[midB - 1];
                } else if (midB == 0) {
                    maxLeft = A[midA - 1];
                } else {
                    maxLeft = Math.max(A[midA - 1], B[midB - 1]);
                }
                
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }
                
                double minRight = 0;
                if (midA == m) {
                    minRight = B[midB];
                } else if (midB == n) {
                    minRight = A[midA];
                } else {
                    minRight = Math.min(A[midA], B[midB]);
                }
                
                return (maxLeft + minRight) / 2.0;
            }
        }
        
        return 0.0; 
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int m = sc.nextInt();
        int n = sc.nextInt();
        
        int[] A = new int[m];
        for (int i = 0; i < m; i++) {
            A[i] = sc.nextInt();
        }
        
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            B[i] = sc.nextInt();
        }
        
        Solution solution = new Solution();
        double median = solution.median(A, B);
        
        System.out.format("%.2f\n", median);
        
        sc.close();
    }
}
