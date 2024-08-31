import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int[][] edges = new int[e][2];
        for (int i = 0; i < e; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }
        Solution obj = new Solution();
        int ans = obj.shortestPathLength(n, edges);
        System.out.println(ans);
        sc.close();
    }
}

class Solution {

    public int shortestPathLength(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        int allVisited = (1 << n) - 1; // All nodes visited mask
        int[][] dp = new int[1 << n][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            dp[1 << i][i] = 0;
            queue.offer(new int[]{1 << i, i});
        }
        
        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            int mask = state[0];
            int u = state[1];
            
            for (int v : graph[u]) {
                int newMask = mask | (1 << v);
                if (dp[newMask][v] > dp[mask][u] + 1) {
                    dp[newMask][v] = dp[mask][u] + 1;
                    queue.offer(new int[]{newMask, v});
                }
            }
        }
        
        int minPathLength = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minPathLength = Math.min(minPathLength, dp[allVisited][i]);
        }
        
        return minPathLength;
    }
}
