import java.util.*;

class Solution {
 
    @SuppressWarnings("unchecked")
    
    public int[] canFinish(int n, int[][] p) {
    //Write your code here
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        int indeg[] = new int[n];
        for(int i=0; i<p.length; i++)
            {
                int u = p[i][0];
                int v = p[i][1];

                adj.get(v).add(u);
                indeg[u]++;
            }
       Queue<Integer> pq = new LinkedList<>();
        for(int i=0; i<n; i++)
            {
                if(indeg[i] == 0)pq.add(i);
            }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty())
            {
                int node = pq.remove();
                ans.add(node);
                for(Integer it: adj.get(node))
                    {
                        indeg[it]--;
                        if(indeg[it]==0) pq.add(it);
                    }
            }
        if(ans.size()==n)
        {
            int[] res = new int[n];
            for(int i=0; i<n; i++)
                {
                    res[i] =  ans.get(i);
                }
            return res;
        }
        int[] res = new int [1];
        res[0]=-1;
        return res;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int prerequisites[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                prerequisites[i][j]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        int []ans=Obj.canFinish(N,prerequisites);
        if(ans.length==0)
            System.out.println(-1);
        else{
            for(int i=0; i<ans.length; i++){
                System.out.print(ans[i]+" ");
            }

            System.out.println("");
        }

    }
}