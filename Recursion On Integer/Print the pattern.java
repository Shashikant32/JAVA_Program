import java.io.*;
import java.util.*;

class Main
{
	public static void starPrint(int n, int star)
    {
        if(star>n)
        {
            return;
        }
        printStar(star);
        System.out.println();
        starPrint(n,star+1);
    }
    public static void solve(int n)
    {
        starPrint(n,1);
    }
    public static void printStar(int count)
    {
        if(count==0)
        {
            return;
        }
        printStar(count-1);
        System.out.print("* ");
    }
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        
        int n=sc.nextInt();
		solve(n);

    }
}