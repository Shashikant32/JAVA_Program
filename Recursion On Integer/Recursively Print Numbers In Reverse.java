import java.util.*;
public class Main {

	public static void printtillN(int N) {
	   // write code here
        if(N==0)
        {
            return ;
        }
        System.out.print(N+ " ");
        printtillN(N-1);
    }
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        printtillN(N);
        sc.close();
    }
}