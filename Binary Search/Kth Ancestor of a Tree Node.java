import java.util.*;

class Solution {
    int[][] ancestor;
    int maxPower;
    
    public int kthAncestor(int n, int[] parent, int node, int k) {
        maxPower = (int)(Math.log(n) / Math.log(2)) + 1;
        ancestor = new int[n][maxPower];
        
        buildAncestorMatrix(n, parent);
        
        return findKthAncestor(node, k);
    }
    
    private void buildAncestorMatrix(int n, int[] parent) {
        for (int i = 0; i < n; i++) {
            ancestor[i][0] = parent[i];
        }
        
        for (int j = 1; j < maxPower; j++) {
            for (int i = 0; i < n; i++) {
                if (ancestor[i][j-1] == -1) {
                    ancestor[i][j] = -1; 
                } else {
                    ancestor[i][j] = ancestor[ancestor[i][j-1]][j-1];
                }
            }
        }
    }
    
    private int findKthAncestor(int node, int k) {
        int current = node;
        
        for (int j = 0; j < maxPower; j++) {
            if ((k & (1 << j)) > 0) { 
                current = ancestor[current][j];
                if (current == -1) {
                    return -1; 
                }
            }
        }
        
        return current;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int parent[] = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = sc.nextInt();
        int node = sc.nextInt();
        int k = sc.nextInt();
        Solution obj = new Solution();
        System.out.println(obj.kthAncestor(n, parent, node, k));
        sc.close();
    }
}