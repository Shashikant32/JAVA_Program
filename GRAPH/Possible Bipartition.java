import java.util.*;

class Solution {

    public int possibleBipartition(int n, int[][] dislikes) {
        // Create an adjacency list for the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Populate the graph with the given dislikes
        for (int[] dislike : dislikes) {
            int u = dislike[0];
            int v = dislike[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Array to store the colors of nodes. 0 means uncolored, 1 and -1 are two colors.
        int[] colors = new int[n + 1];
        
        // Perform BFS for each component of the graph
        for (int i = 1; i <= n; i++) {
            if (colors[i] == 0) {
                if (!bipartiteBFS(graph, colors, i)) {
                    return 0; // Not possible to bipartition
                }
            }
        }
        
        return 1; // Possible to bipartition
    }

    private boolean bipartiteBFS(List<List<Integer>> graph, int[] colors, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        colors[start] = 1; // Start coloring with 1

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int currentColor = colors[node];
            int neighborColor = -currentColor;

            for (int neighbor : graph.get(node)) {
                if (colors[neighbor] == 0) {
                    // Assign opposite color to the neighbor
                    colors[neighbor] = neighborColor;
                    queue.offer(neighbor);
                } else if (colors[neighbor] == currentColor) {
                    // If neighbor has the same color, then it's not bipartite
                    return false;
                }
            }
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] dislike = new int[M][2];
        for (int i = 0; i < M; i++) {
            dislike[i][0] = sc.nextInt();
            dislike[i][1] = sc.nextInt();
        }

        Solution obj = new Solution();
        System.out.println(obj.possibleBipartition(N, dislike));
    }
}
