import java.util.*;

class Solution {
    // Helper method for DFS
    public static boolean dfs(ArrayList<Integer>[] adj, int[] vis, int[] pvis, int node, int parent) {
        // Mark the node as visited and part of the current path
        vis[node] = 1;
        pvis[node] = 1;

        // Recur for all adjacent vertices
        for (Integer it : adj[node]) {
            if (vis[it] == 0) {
                // If the adjacent node has not been visited, recurse
                if (dfs(adj, vis, pvis, it, node)) {
                    return true;
                }
            } else if (pvis[it] == 1 && it != parent) {
                // If an adjacent node is visited and not the parent, a cycle is detected
                return true;
            }
        }
        // Remove the node from the current path
        pvis[node] = 0;
        return false;
    }

    // Method to check if the graph contains a cycle
    public boolean isCyclic(int V, ArrayList<Integer>[] adj) {
        int[] vis = new int[V];
        int[] pvis = new int[V];
        // Check for cycles in each component of the graph
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (dfs(adj, vis, pvis, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V, E;
        V = sc.nextInt();
        E = sc.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[V];
        
        // Initialize the adjacency list
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        
        // Input edges
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u].add(v);
            adj[v].add(u); // Since the graph is undirected
        }
        
        // Create Solution object and check for cycles
        Solution obj = new Solution();
        boolean ans = obj.isCyclic(V, adj);
        
        // Output the result
        if (ans) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
        
        sc.close(); // Close scanner
    }
}
