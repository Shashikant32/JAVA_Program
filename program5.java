import java.util.*;

class Main {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
        //Print Even Numbers
        int n = scanner.nextInt();
        for(int i=0; i<=n; i++)
            {
                if(i%2==0)
                {
                  System.out.print(i+" ");  
                }
            }
	}
}

