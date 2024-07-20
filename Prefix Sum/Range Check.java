import java.util.*;

class Solution {
    public boolean RangeCheck(int[][] intervals, int a, int b) {
        int []p = new int[51];
        for(int i=0; i<intervals.length; i++)
            {
                int l = intervals[i][0];
                int r = intervals[i][1];
                p[l]++;
                if(r<50)
                {
                    p[r+1]--;
                }
            }
        for(int i= 1; i<51; i++)
            {
                p[i] += p[i-1];
            }
        for(int i=a; i<=b; i++)
            {
                if(p[i]==0)
                {
                    return false;
                }
            }
        return true;

    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[][] intervals = new int[n][2];
        for(int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
	    Solution Obj = new Solution();
        if(Obj.RangeCheck(intervals, a, b))
            System.out.println("true");
        else
            System.out.println("false");
    }
}