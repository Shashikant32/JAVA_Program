import java.io.*;
import java.util.*;

class Main
{

	public static void solve(int n)
    {
        for(int i=1; i<=n; i++)
            {
                for(int j=1; j<=i; j++)
                    {
                        System.out.print("* ");
                    }
                System.out.println(" ");
            }
        
    }
	
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        
        int n=sc.nextInt();
		solve(n);

    }
}