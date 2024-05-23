import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  
        int m = sc.nextInt();

        int mat[][] = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                mat[i][j] = sc.nextInt();
            }
        }   
        SubrectangleQueries answer = new SubrectangleQueries(mat);
        int q = sc.nextInt();
        for(int i = 0; i < q; i++) {
            int t = sc.nextInt();  
            if(t == 0) {
                int a, b, c, d, e;
                a = sc.nextInt();
                b = sc.nextInt();
                c = sc.nextInt();
                d = sc.nextInt();
                e = sc.nextInt();
                answer.updateSubrectangle(a, b, c, d, e);
            } else {
                int a, b;
                a = sc.nextInt();
                b = sc.nextInt();
                System.out.println(answer.getValue(a, b));
            }
        }
    }
}

class SubrectangleQueries {
    private int[][] rectangle;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for(int i = row1; i <= row2; i++) {
            for(int j = col1; j <= col2; j++) {
                rectangle[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return rectangle[row][col];
    }
}
