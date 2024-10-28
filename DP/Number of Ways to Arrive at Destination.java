import java.util.*;

@SuppressWarnings("unchecked")
class Solution {
    public static int countPaths(int n, int[][] roads) {
        // Create an adjacency list for the graph
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int time = road[2];
            graph[u].add(new int[]{v, time});
            graph[v].add(new int[]{u, time});
        }

        // Dijkstra's algorithm
        int[] minTime = new int[n];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        minTime[0] = 0;

        long[] ways = new long[n];
        ways[0] = 1; // There's one way to reach the starting point

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{0, 0}); // {intersection, time}

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int time = curr[1];

            // If we have already found a shorter time, continue
            if (time > minTime[node]) {
                continue;
            }

            // Explore neighbors
            for (int[] neighbor : graph[node]) {
                int nextNode = neighbor[0];
                int travelTime = neighbor[1];

                if (minTime[node] + travelTime < minTime[nextNode]) {
                    minTime[nextNode] = minTime[node] + travelTime;
                    ways[nextNode] = ways[node]; // update the number of ways to reach nextNode
                    pq.add(new int[]{nextNode, minTime[nextNode]});
                } else if (minTime[node] + travelTime == minTime[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % (1000000007); // add the number of ways
                }
            }
        }

        return (int) ways[n - 1]; // Return the number of ways to reach the destination
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }
        System.out.print(Solution.countPaths(n, edges));
    }
}
