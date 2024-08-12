import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n, m, k;
      n = sc.nextInt();
      m = sc.nextInt();
      k = sc.nextInt();
      int[][] a = new int[m][3];
      for (int i = 0; i < m; i++) {
         int u, v, w;
         u = sc.nextInt();
         v = sc.nextInt();
         w = sc.nextInt();
         a[i][0] = u;
         a[i][1] = v;
         a[i][2] = w;   
      }
      Solution ob = new Solution();
      System.out.println(ob.networkDelayTime(a, n, k));
   }
}

class Solution {
    // Helper class to represent graph edges
    static class Edge {
        int destination;
        int weight;
        
        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
    
    // Method to find the network delay time
    public int networkDelayTime(int[][] times, int N, int K) {
        // Create an adjacency list for the graph
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(new Edge(v, w));
        }
        
        // Distance array to track shortest distance from source node K
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;
        
        // Priority queue to process nodes based on shortest distance
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[] {K, 0});
        
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int u = node[0];
            int currentDist = node[1];
            
            if (currentDist > dist[u]) continue;
            
            if (!graph.containsKey(u)) continue;
            
            for (Edge edge : graph.get(u)) {
                int v = edge.destination;
                int weight = edge.weight;
                
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new int[] {v, dist[v]});
                }
            }
        }
        
        // Find the maximum distance from the source to any node
        int maxDist = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; // If any node is unreachable
            }
            maxDist = Math.max(maxDist, dist[i]);
        }
        
        return maxDist;
    }
}
