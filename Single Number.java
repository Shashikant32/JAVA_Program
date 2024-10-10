import java.util.*;

class Solution {
    public void singleElement(int[] A, int n) {
        int singleNumber = 0;
        for (int i = 0; i < n; i++) {
            singleNumber ^= A[i];
        }
        System.out.println(singleNumber);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        obj.singleElement(A, n);
        sc.close();
    }
}
