import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        int v = Integer.parseInt(st[0]);
        int e = Integer.parseInt(st[1]);

        int[] wells = new int[v];
        String[] words = br.readLine().split(" ");

        for (int i = 0; i < wells.length; i++) {
            wells[i] = Integer.parseInt(words[i]);
        }

        int[][] pipes = new int[e][3];
        for (int i = 0; i < e; i++) {
            String[] st1 = br.readLine().split(" ");
            pipes[i][0] = Integer.parseInt(st1[0]) - 1;
            pipes[i][1] = Integer.parseInt(st1[1]) - 1;
            pipes[i][2] = Integer.parseInt(st1[2]);
        }

        System.out.println(minCostToSupplyWater(v, wells, pipes));
    }

    public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<int[]> edges = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            edges.add(new int[] { n, i, wells[i] });
        }
        
        for (int[] pipe : pipes) {
            edges.add(new int[] { pipe[0], pipe[1], pipe[2] });
        }

        edges.sort((a, b) -> Integer.compare(a[2], b[2]));

        // Kruskal's algorithm to find MST
        UnionFind uf = new UnionFind(n + 1);
        int minCost = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];

            if (uf.find(u) != uf.find(v)) {
                uf.union(u, v);
                minCost += cost;
            }
        }

        return minCost;
    }
}

class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}
