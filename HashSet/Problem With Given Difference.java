import java.io.*;
import java.util.*;

class Solution {
    public int givenDifference(int []A, int n, int B) {
        // for(int i=0; i<A.length-1; i++)
        //     {
        //         for(int j=i+1; j<A.length; j++)
        //             {
        //                 if(Math.abs(A[i]-A[j]) == B)
        //                 {
        //                     return 1;
        //                 }
        //             }
        //     }
        // return 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++)
            {
                int x1 = A[i]+B;
                int x2 = A[i]-B;
                if(set.contains(x1) || set.contains(x2))
                {
                    return 1;
                }
                set.add(A[i]);
            }
        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,B;
        n = sc.nextInt();
        int []mat=new int[n];
        for(int i=0;i<n;++i){
            mat[i]=sc.nextInt();
        }
        B = sc.nextInt();
        Solution Obj = new Solution();
        System.out.println(Obj.givenDifference(mat,n,B));
        System.out.println('\n');
    }
}
