import java.util.*;

class Solution {
    public static int[] largestPermutation(int[] A, int B) {
        int N = A.length;
        Map<Integer, Integer> positionMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            positionMap.put(A[i], i);
        }
        
        for (int i = 0; i < N && B > 0; i++) {
            int maxNumber = N - i;
            if (A[i] != maxNumber) {
                int pos = positionMap.get(maxNumber);
                
                int temp = A[i];
                A[i] = A[pos];
                A[pos] = temp;
                
                positionMap.put(A[i], i);
                positionMap.put(A[pos], pos);
                
                B--;
            }
        }
        return A;
    }
}

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++)
            A[i] = sc.nextInt();

        int b = sc.nextInt();
        Solution obj = new Solution();
        int[] ans = obj.largestPermutation(A, b);

        for (int i = 0; i < n; i++)
            System.out.print(ans[i] + " ");
    }
}
