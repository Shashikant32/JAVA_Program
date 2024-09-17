import java.util.*;

class Accio {
    public int[][] MatMul(int m, int p, int n, int[][] A, int[][] B) {
        int[][] C = new int[m][n];
        multiplyMatrixRec(A, B, C, 0, 0);
        return C;
    }
    
    private void multiplyMatrixRec(int[][] A, int[][] B, int[][] C, int i, int j) {
        int m = A.length;
        int p = B.length;
        int n = B[0].length;
        
        if (i >= m) return;
        
        if (j >= n) {
            multiplyMatrixRec(A, B, C, i + 1, 0);
            return;
        }
        
        C[i][j] = computeElement(A, B, i, j, 0);
        
        multiplyMatrixRec(A, B, C, i, j + 1);
    }
    
    private int computeElement(int[][] A, int[][] B, int i, int j, int k) {
        int p = A[0].length;
        
        if (k >= p) return 0;
        
        return A[i][k] * B[k][j] + computeElement(A, B, i, j, k + 1);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, p, n;
        m = sc.nextInt();
        p = sc.nextInt();
        n = sc.nextInt();
        int[][] A = new int[m][p];
        int[][] B = new int[p][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < p; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < p; i++) {
            for(int j = 0; j < n; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        Accio Obj = new Accio();
        int[][] Ans = Obj.MatMul(m, p, n, A, B);

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(Ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
