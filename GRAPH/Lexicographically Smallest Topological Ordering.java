import java.util.*;

class Solution {
    public static ArrayList<Integer> topologicalSort(int V, ArrayList<ArrayList<Integer>> graph) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] inDegree = new int[V + 1];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Compute in-degrees
        for (int u = 1; u <= V; ++u) {
            for (int v : graph.get(u)) {
                inDegree[v]++;
            }
        }
        
        // Add all vertices with in-degree 0 to the priority queue
        for (int i = 1; i <= V; ++i) {
            if (inDegree[i] == 0) {
                minHeap.add(i);
            }
        }
        
        while (!minHeap.isEmpty()) {
            int u = minHeap.poll();
            result.add(u);
            
            for (int v : graph.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    minHeap.add(v);
                }
            }
        }
        
        // If result size is not equal to number of vertices, there's a cycle
        if (result.size() != V) {
            result.clear();
            result.add(-1);
        }
        
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = Integer.parseInt(sc.next());
        int E = Integer.parseInt(sc.next());
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= V; ++i) {
            adj.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < E; ++i) {
            int u = Integer.parseInt(sc.next());
            int v = Integer.parseInt(sc.next());
            adj.get(u).add(v);
        }
        
        Solution ob = new Solution();
        ArrayList<Integer> ans = ob.topologicalSort(V, adj);
        for (int i = 0; i < ans.size(); ++i) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
