import java.util.*;

class Solution {
    public void printMatrixColumnwise(int[][] mat, int n, int m) {
        //Print Matrix Column Wise
        for(int j=0; j<m; j++)
            {
                for(int i=0; i<n; i++)
                    {
                        System.out.print(mat[i][j]+" ");
                    }
            }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t > 0) {
            int n;
            int m;
            n = sc.nextInt();
            m = sc.nextInt();
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    matrix[i][j] = sc.nextInt();
            Solution Obj = new Solution();
            Obj.printMatrixColumnwise(matrix, n, m);
            System.out.println();
            t--;
        }
        sc.close();
    }
}