import java.util.*;

public class Main {
    public static int maximaMinima(int[][] mat,int n) {
        //Maxima Minima
          for (int i = 0; i < n; i++) {
            int minRowValue = Integer.MAX_VALUE;
            int minRowColIndex = -1;

            
            for (int j = 0; j < n; j++) {
                if (mat[i][j] < minRowValue) {
                    minRowValue = mat[i][j];
                    minRowColIndex = j;
                }
            }
            boolean isMaxInColumn = true;
            for (int k = 0; k < n; k++) {
                if (mat[k][minRowColIndex] > minRowValue) {
                    isMaxInColumn = false;
                    break;
                }
            }

            if (isMaxInColumn) {
                return minRowValue;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
        int result = maximaMinima(matrix,n);
        System.out.println(result);
        sc.close();
    }
}