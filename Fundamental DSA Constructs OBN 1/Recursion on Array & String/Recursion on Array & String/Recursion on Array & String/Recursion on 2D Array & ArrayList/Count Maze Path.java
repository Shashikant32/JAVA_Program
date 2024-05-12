import java.io.*;
import java.util.*;

public class Main{
    static int countMazePath(int n, int m)
    {
           if (n == 1 || m == 1)
            return 1;
        
        return countMazePath(n-1, m) + countMazePath(n, m-1);
    }
	public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int m, n;
        n = sc.nextInt();
        m = sc.nextInt();
        System.out.println(countMazePath(n, m));
    }
}