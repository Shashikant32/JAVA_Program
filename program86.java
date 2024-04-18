import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Alt Matrix Sum
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int [][]mat=new int[n][n];
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                mat[i][j]=sc.nextInt();
            }
        }
        int[] sums = alternateMatrixSum(mat, n);
        System.out.println(sums[0]);
        System.out.println(sums[1]);
    }

    public static int[] alternateMatrixSum(int [][]mat, int n) {
             int[] sums = new int[2]; 

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = mat[i][j];

                
                if ((i + j) % 2 == 0) {
                    sums[0] += value; 
                } else {
                    sums[1] += value; 
                }
            }
        }
        return sums;
    }
}
