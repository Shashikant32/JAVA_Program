import java.io.*;
import java.util.*;

class Solution {
    public void firstElementToOccurKTimes(int[] num, int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++)
            {
                if(map.containsKey(num[i]))
                {
                    int currfq= map.get(num[i]);
                    map.put(num[i],currfq+1);
                }else
                {
                    map.put(num[i],1);
                }
                if(map.get(num[i])==k)
                {
                    System.out.println(num[i]);
                    return;
                }
            }
        System.out.println(-1);
        
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k;
        n=sc.nextInt();
        k=sc.nextInt();
        int nums[] = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        Solution Obj = new Solution();
        Obj.firstElementToOccurKTimes(nums,n,k);  
        System.out.println();
    }
}