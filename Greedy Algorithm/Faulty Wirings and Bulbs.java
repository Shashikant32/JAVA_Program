import java.util.*;

class Solution {
    public static int bulbs(int[] A) {
        int presses = 0;
        boolean flip = false;
        
        for (int bulb : A) {
            int effectiveState = bulb ^ (flip ? 1 : 0);
            
            if (effectiveState == 0) {
                presses++;
                flip = !flip; 
            }
        }
        
        return presses;
    }
}

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        sc.close();
        
        Solution solution = new Solution();
        System.out.println(solution.bulbs(A));
    }
}
