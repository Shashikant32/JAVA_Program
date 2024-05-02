import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       int X,N;
        X = sc.nextInt();        
        N = sc.nextInt();

        System.out.println(power(X,N));		
    }

	public static long power(int x, int y)
    {
		if(y==0)
        {
            return 1;
        }
        long temp = power(x,y/2);
        if(y%2==0)
        {
            return temp*temp;
        }else
        {
            return x * temp * temp;
        }
    }
}
