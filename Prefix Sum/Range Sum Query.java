import java.util.*;

class Solution {
        public int[] sumQuery(int[] arr, int[][] ranges) {
            int n= arr.length, q= ranges.length;
            int[] ans = new int[q];
            int[] pref = new int[n];
            pref[0] = arr[0];
            
            for(int i=1; i<n; i++)
                {
                    pref[i]= pref[i-1]+ arr[i];
                }
            for(int i=0; i<q; i++)
                {
                    int l= ranges[i][0];
                    int r= ranges[i][1];
                    if(l>0)
                    {
                        ans[i] = pref[r] - pref[l-1];
                        
                    }else
                    {
                        ans[i]=pref[r];
                    }
                    
                }
            return ans;
        }
}

public class Main {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int m;
        m = sc.nextInt();
        int[][] ranges = new int[m][2];
        for(int i = 0; i < m; i++) {
            ranges[i][0] = sc.nextInt();
            ranges[i][1] = sc.nextInt();
        }
        Solution Obj = new Solution();
        int[] ans = Obj.sumQuery(arr, ranges);
        for(int i =0; i< ans.length; i++)
            System.out.print(ans[i] + " ");
    }
}