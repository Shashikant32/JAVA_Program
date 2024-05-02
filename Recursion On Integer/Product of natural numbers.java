import java.util.*;

public class Main {
	static long product(int n){
        if(n==1)
        {
            return 1;
        }
        long fact = n*product(n-1);
       return fact;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        System.out.println(product(n));
    }
}