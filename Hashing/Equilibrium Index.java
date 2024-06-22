import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int ans = Solution.findEquilibriumIndex(a);
        System.out.println(ans);
    }
}

class Solution {
    static int findEquilibriumIndex(int[] a) {

        // if(a.length<=1) return 0;
        int totalsum=0;
            for(int ele :a)
            {
                totalsum += ele;
            }
        int lsum =0;
        for(int i=0; i<a.length; i++)
            {
                int rsum =totalsum - lsum -a[i];
                if(lsum==rsum) return i;
                lsum += a[i];
                
            }
        return -1;
    }
}