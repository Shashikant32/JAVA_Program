import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < M; i++) {
            ArrayList<Integer> e = new ArrayList<Integer>();
            e.add(sc.nextInt());
            e.add(sc.nextInt());
            Edges.add(e);
        }
        Solution ob = new Solution();
        if (ob.check(N, M, Edges)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        sc.close();
    }

}

class Solution {
        
    boolean dfs(ArrayList<ArrayList<Integer>> adj, int node, int [] pvis, int N, int ct)
      {
        pvis[node]=1; ct++;
        if(ct==N) return true;
        // iterate in adj
        for(Integer it:adj.get(node))
            {
                if(pvis[it] == 0)
                {
                    if(dfs(adj,it,pvis,N,ct))return true;
                }
            }
        pvis[node]=0;
        return false;
    }
     boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) {
        // your code here
        // adj  code 
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=N; i++) adj.add(new ArrayList<>());
        // fill adj
         for(int i=0; i<M; i++)
             {
                 int u = Edges.get(i).get(0);
                 int v = Edges.get(i).get(1);
                 adj.get(u).add(v);
                 adj.get(v).add(u);    
             }
        // pvis
        int[] pvis = new int [N+1];
        for(int i=1; i<=N; i++)
            {
                // if dfs states hamil path exists
                if(dfs(adj,i,pvis,N,0)) return true;
            }
    return false;
    }
}