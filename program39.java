import java.io.*;
import java.util.*;

class Main
{
    public static void main(String args[])throws IOException
    // N Stars
    {
        Scanner sc = new Scanner(System.in);
        
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
            {
                System.out.print("* ");
            }
        System.out.println();
        for(int i=0; i<n; i++)
            {
                System.out.println("* ");
            }
    }
}
