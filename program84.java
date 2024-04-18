import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Spirally traversing a matrix
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        int [][]mat=new int[n][m];
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                mat[i][j]=sc.nextInt();
            }
        }

        spirallyTraverse(mat,n,m);     
        System.out.println('\n');
    }

    public static void spirallyTraverse(int [][]mat , int n, int m) {
        int rowStart=0;
        int rowEnd=n-1;
        int colStart=0;
        int colEnd=m-1;
        while(rowStart<=rowEnd && colStart <= colEnd)
            {
            for(int i=colStart; i<=colEnd; i++)
                {
                    System.out.print(mat [rowStart][i] +" ");
                }
             rowStart++;
             for(int i=rowStart; i<=rowEnd; i++)
                 {
                     System.out.print(mat [i][colEnd] +" ");
                 }
            colEnd--;
            if(rowStart<rowEnd)
            {
               for(int j=colEnd; j>=colStart; j--)
                 {
                     System.out.print(mat [rowEnd] [j] +" ");
                 }
            rowEnd--;  
            }
            if(colStart<colEnd)
            {
               for(int j=rowEnd; j>=rowStart; j--)
                 {
                     System.out.print(mat [j][colStart] +" ");
                 }
            colStart++;  
            }
           
         }
    }
}