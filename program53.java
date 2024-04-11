import java.util.*;

public class Main {
	static int printSum(int N){
        //Natural Sum
        int sum = (N * (N + 1)) / 2;
        return sum;
    }
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();    
        System.out.println(printSum(N));
    }
}