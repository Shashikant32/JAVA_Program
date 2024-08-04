import java.util.*;

class Solution {
    public static ArrayList<Integer> dijkstra(ArrayList<ArrayList<Integer>> edges, int vertices, int edgesCount, int source) {
        // Create adjacency list
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (ArrayList<Integer> edge : edges) {
            int x = edge.get(0);
            int y = edge.get(1);
            int w = edge.get(2);
            graph.get(x).add(new int[]{y, w});
            graph.get(y).add(new int[]{x, w});
        }
        
        // Distance array
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        
        // Priority queue for Dijkstra's algorithm
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{source, 0});
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            int currentDist = current[1];
            
            // Skip processing if we have already found a better path
            if (currentDist > dist[u]) {
                continue;
            }
            
            // Relax edges
            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }
        
        // Convert distances to ArrayList
        ArrayList<Integer> result = new ArrayList<>();
        for (int d : dist) {
            result.add(d == Integer.MAX_VALUE ? 2147483647 : d);
        }
        return result;
    }
}

class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t--;
            int v = sc.nextInt();
            int e = sc.nextInt();
            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < e; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int w = sc.nextInt();
                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(x);
                edge.add(y);
                edge.add(w);
                edges.add(edge);
            }
            ArrayList<Integer> result = Solution.dijkstra(edges, v, e, 0);
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i) + " ");
            }
            System.out.println("");
        }
        sc.close();
    }
}
