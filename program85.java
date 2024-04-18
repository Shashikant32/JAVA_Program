import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        // Boolean Matrix Problem
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int nums[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                nums[i][j] = sc.nextInt();
            }
        }
        int[][] ans=BooleanMatrixProblem(m,n,nums);
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                System.out.print(ans[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static int[][] BooleanMatrixProblem(int m,int n,int[][] mat){
    boolean[] fillRow = new boolean[m];
        
        // Check each row for presence of 1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    fillRow[i] = true;
                    break;
                }
            }
        }
        
        // Fill rows with 1s
        for (int i = 0; i < m; i++) {
            if (fillRow[i]) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = 1;
                }
            }
        }
        
        return mat;
    }

}