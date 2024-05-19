import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(read.readLine());

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String S[] = read.readLine().split(" ");
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < N; j++)
                temp.add(Integer.parseInt(S[j]));
            adj.add(temp);
        }

        Solution ob = new Solution();
        System.out.println(ob.components(adj, N));
    }
}

class Solution {
    private void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, int N) {
        visited[node] = true;
        for (int i = 0; i < N; i++) {
            if (adj.get(node).get(i) == 1 && !visited[i]) {
                dfs(i, visited, adj, N);
            }
        }
    }

    int components(ArrayList<ArrayList<Integer>> adj, int N) {
        boolean[] visited = new boolean[N];
        int componentCount = 0;

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                componentCount++;
                dfs(i, visited, adj, N);
            }
        }

        return componentCount;
    }
}
