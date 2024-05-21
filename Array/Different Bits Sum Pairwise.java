import java.util.*;

class Solution{
    public int cntBits(int[] A) {
        long result = 0;
        int n = A.length;
        int MOD = 1000000007;

        // Iterate through each bit position
        for (int i = 0; i < 31; i++) {
            long countOnes = 0;
            long countZeros = 0;
            for (int j = 0; j < n; j++) {
                if ((A[j] & (1 << i)) > 0) {
                    countOnes++;
                } else {
                    countZeros++;
                }
            }
            
            result = (result + countOnes * countZeros * 2) % MOD;
        }
        return (int) result;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for(int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        System.out.println(obj.cntBits(A));
    }
}
