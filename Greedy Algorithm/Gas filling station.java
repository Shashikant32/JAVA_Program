import java.util.*;

class Solution {
    public int filling(int A[], int B[], int n) {
        int totalGas = 0, totalCost = 0, currentBalance = 0, startIndex = 0;
        
        for (int i = 0; i < n; i++) {
            totalGas += A[i];
            totalCost += B[i];
            currentBalance += A[i] - B[i];
            
            if (currentBalance < 0) {
                startIndex = i + 1;
                currentBalance = 0;
            }
        }
        
        if (totalGas < totalCost) {
            return -1;
        }
        
        return startIndex;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        
        sc.close();
        
        Solution Obj = new Solution();
        System.out.print(Obj.filling(a, b, n));
    }
}
