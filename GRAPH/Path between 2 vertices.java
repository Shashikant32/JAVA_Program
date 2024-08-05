import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  
        int M = sc.nextInt(); 

        ArrayList<ArrayList<Integer>> Edges = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Edges.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            Edges.get(u - 1).add(v - 1);
            Edges.get(v - 1).add(u - 1);
        }

        int U = sc.nextInt();
        int V = sc.nextInt();

        Solution ob = new Solution();
        if (ob.check(N, M, Edges, U - 1, V - 1)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        sc.close();
    }
}

class Solution {

    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges, int U, int V) {
        if (U == V) {
            return true;
        }

        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(U);
        visited[U] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : Edges.get(current)) {
                if (!visited[neighbor]) {
                    if (neighbor == V) {
                        return true;  // Path found
                    }
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        
        // No path found
        return false;
    }
}
