import java.util.*;

class Solution{
    public static int longestSubarray(int[] arr){
        HashMap<String,Integer> map = new HashMap<>();
        int zero =0;
        int ones=0;
        int two=0;
        
       int maxLen=0;
        for(int i=0; i<arr.length; i++)
            {
            if(arr[i]==0) zero++;
            else if(arr[i]==1) ones++;
            else two++;

            String key = String.valueOf(ones-zero)+ '$'+ String.valueOf(two-ones);
            if(map.containsKey(key)==false)
            {
                map.put(key,i);
            }else
            {
                maxLen = Math.max(maxLen,i-map.get(key));
            }
            }
            // for(String k : map.keySet()) // print the value 
            //     {
            //         System.out.println(k + "->" + map.get(k));
            //     }
           return maxLen;
    }

}
public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        Solution Obj =  new Solution();
        System.out.println(Obj.longestSubarray(arr));
    }
}
