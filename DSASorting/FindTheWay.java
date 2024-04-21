import java.util.*;

public class Main {
    public static int[] findTheWay(int[][] matrix,int m,int n) {
    
        int row = 0, col = 0;
        int direction = 0; 
        int prevRow=0;
        int prevCol=0;

        while (row >= 0 && row <=m-1 && col >= 0 && col <=n-1) {
            prevRow=row;
            prevCol=col;
            if(matrix[row][col]==0)
            {
                if (direction == 0) {
                    col++;
                } else if (direction == 1) {
                    row++;
                } else if (direction == 2) {
                    col--;
                } else if (direction == 3) {
                    row--;
                }
            }else//different diraction
            {
                if(direction==0)
                {
                    direction=1;
                    row++;
                }else if(direction==1)
                {
                    direction=2;
                    col--;
                }else if(direction==2)
                {
                    direction=3;
                    row--;
                }else
                {
                    direction=0;
                    col++;
                }
            }
            
        }

        // return new int[]{row, col};
        int ans[] = new int[2];
        ans [0] = prevRow;
        ans[1] = prevCol;
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
		}
        int result[] = findTheWay(matrix,m,n);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
        sc.close();
    }
}