import java.io.*;
import java.util.*;

class Edge {
    int src;
    int nbr;

    Edge(int src, int nbr) {
        this.src = src;
        this.nbr = nbr;
    }
}

class Solution {
    public static int perfectStudents(int vtces, ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[vtces];
        List<Integer> componentSizes = new ArrayList<>();
        
        for (int i = 0; i < vtces; i++) {
            if (!visited[i]) {
                int size = dfs(graph, visited, i);
                componentSizes.add(size);
            }
        }
        
        int totalPairs = (vtces * (vtces - 1)) / 2;
        
        int intraClubPairs = 0;
        for (int size : componentSizes) {
            if (size > 1) {
                intraClubPairs += (size * (size - 1)) / 2;
            }
        }
        
        return totalPairs - intraClubPairs;
    }

    private static int dfs(ArrayList<Edge>[] graph, boolean[] visited, int src) {
        Stack<Integer> stack = new Stack<>();
        stack.push(src);
        visited[src] = true;
        int size = 0;
        
        while (!stack.isEmpty()) {
            int node = stack.pop();
            size++;
            
            for (Edge edge : graph[node]) {
                if (!visited[edge.nbr]) {
                    visited[edge.nbr] = true;
                    stack.push(edge.nbr);
                }
            }
        }
        
        return size;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < k; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        System.out.println(Solution.perfectStudents(n, graph));
    }
}
