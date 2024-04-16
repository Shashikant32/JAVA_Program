import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Sum of upper and lower triangles
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();

        triangleSums(n, matrix);
        sc.close();
    }

    public static void triangleSums(int n, int[][] matrix) {
    int upperSum = 0;
        int lowerSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Sum of upper triangle elements
                if (j >= i) {
                    upperSum += matrix[i][j];
                }
                // Sum of lower triangle elements
                if (j <= i) {
                    lowerSum += matrix[i][j];
                }
            }
        }

        System.out.println(upperSum + " " + lowerSum);
    }
}