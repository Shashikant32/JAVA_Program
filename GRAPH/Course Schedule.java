import java.util.*;

class Solution {

    @SuppressWarnings("unchecked")
    public int canFinish(int n, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[n];
        int[] inDegree = new int[n];
        
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] prerequisite : prerequisites) {
            int ai = prerequisite[0];
            int bi = prerequisite[1];
            adj[bi].add(ai); 
            inDegree[ai]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int processedCourses = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            processedCourses++;

            for (int dependentCourse : adj[course]) {
                inDegree[dependentCourse]--;
                if (inDegree[dependentCourse] == 0) {
                    queue.add(dependentCourse);
                }
            }
        }

        return processedCourses == n ? 1 : 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] prerequisites = new int[M][2];

        for (int i = 0; i < M; i++) {
            prerequisites[i][0] = sc.nextInt();
            prerequisites[i][1] = sc.nextInt();
        }

        Solution obj = new Solution();
        System.out.println(obj.canFinish(N, prerequisites));
    }
}
