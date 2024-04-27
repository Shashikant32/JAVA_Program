import java.io.*;
import java.util.*;

class Main
{
	public static void printXY(int x,int y){
                
            for(int i=x; i<=y; i++)
                {
                    System.out.print(x + " ");
                    x++;
                }
    }
    public static void main(String args[])throws IOException
    {
        
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int y=sc.nextInt();

        printXY(x,y);
        
        
    }
}
