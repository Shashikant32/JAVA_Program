import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
		// Reverse digits of a Number
        int rev=0;
        for(;n!=0;)
            {
                int digit=n%10;
                rev=rev*10+digit;
                n=n/10;
            }
        System.out.print(rev);
    }
}