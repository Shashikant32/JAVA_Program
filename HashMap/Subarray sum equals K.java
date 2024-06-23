import java.io.*;
import java.util.*;
 
 class Solution
{
         static int solve(int N, int[] Arr, int K){
           HashMap<Integer,Integer> freqMap = new HashMap<>();
             freqMap.put(0,1);
             int ans=0;
             int runningSum=0;
             for(int i=0; i<N; i++)
                 {
                     runningSum +=Arr[i];
                     if(freqMap.containsKey(runningSum-K))
                     {
                         ans+=freqMap.get(runningSum-K);
                     }
                     freqMap.put((runningSum), freqMap.getOrDefault(runningSum,0)+1);
                 }
                    // for(int k : freqMap.keySet())
                    //     {
                    //         System.out.println(k + "->"+freqMap.get(k));
                    //     }
             return ans;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int N = Integer.parseInt(br.readLine().trim());
         String[] arr_Arr = br.readLine().split(" ");
         int[] Arr = new int[N];
         for(int i_Arr = 0; i_Arr < arr_Arr.length; i_Arr++)
         {
         	Arr[i_Arr] = Integer.parseInt(arr_Arr[i_Arr]);
         }
         int K = Integer.parseInt(br.readLine().trim());
 
         int out_ =  Solution.solve(N, Arr, K);
         System.out.println(out_);
 
         wr.close();
         br.close();
    }
}