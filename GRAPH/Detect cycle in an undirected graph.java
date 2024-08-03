import java.io.*;
import java.util.*;

class Solution {
    public static boolean dfs(ArrayList<ArrayList<Integer>> adj, int node, int[] vis, int parent) {
        // Mark this node as visited
        vis[node] = 1;

        // Recur for all adjacent nodes
        for (Integer it : adj.get(node)) {
            if (vis[it] == 0) {
                // If the adjacent node has not been visited, recurse
                if (dfs(adj, it, vis, node)) {
                    return true;
                }
            } else if (it != parent) {
                // If an adjacent node is visited and not the parent, there's a cycle
                return true;
            }
        }
        return false;
    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V]; // Visited array
        
        // Check for cycles in each connected component
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (dfs(adj, i, vis, -1)) {
                    return true;
                }
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N, E;
        N = sc.nextInt(); // Number of nodes
        E = sc.nextInt(); // Number of edges
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        // Initialize adjacency list
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<Integer>());
        }
        
        // Input edges
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        // Check for cycle
        boolean ans = Solution.isCycle(N, adj);
        if (ans)
            System.out.println("1");
        else
            System.out.println("0");
        
        sc.close(); // Close scanner
    }
}
