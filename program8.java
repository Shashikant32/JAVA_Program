import java.util.*;

class Main {
	public static void main(String args[]) {
        // Print Even Numbers
		Scanner scanner = new Scanner(System.in);
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

