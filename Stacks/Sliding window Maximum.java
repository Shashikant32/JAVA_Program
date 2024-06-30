import java.util.*;

class Solution{
    static int[] SlidingWindowMaximum(int N, int K, int[] arr){
        Deque<Integer> dq = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<N; i++)
            {
                int startIndexOfWindow = i-K+1;
                if(dq.size() > 0 && dq.getLast() < startIndexOfWindow)
                {
                    dq.removeLast();
                }
            
                while(dq.size() > 0 && arr[dq.getFirst()] < arr[i])
                    {
                        dq.removeFirst();
                    }
                dq.addFirst(i);
                if(i>=K-1)
                {
                    ans.add(arr[dq.getLast()]);
                }
            }
        int a[] = new int [ans.size()];
        for(int i=0; i< ans.size(); i++)
        {
            a[i] = ans.get(i);
        }
    return a;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int nums[]=new int[n];
        for(int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        int[] ans=obj.SlidingWindowMaximum(n,k,nums);
        for(int i=0;i<ans.length;++i){
            System.out.print(ans[i] + " ");
        }
    }
}
