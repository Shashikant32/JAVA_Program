import java.util.*;
import static java.lang.Math.ceil;

public class Main {
	  static long number = 1000000007;

    static long NthEvenFibonacci(long n) {
        if (n <= 0)
            return 0;
        else if (n == 1)
            return 2;
        else {
            long a = 0;
            long b = 2;
            long c = 0;
            for (int i = 2; i <= n; i++) {
                c = (4 * b + a) % number;
                a = b;
                b = c;
            }
            return c;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(NthEvenFibonacci(n));
    }
}