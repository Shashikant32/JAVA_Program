import java.util.*;
import java.io.*;

class Solution{
    public void isSparse(int n){
         //Write code here and print output
         if((n &(n >> 1))== 0)  
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Solution obj = new Solution();
        obj.isSparse(n);
    }
}