import java.util.*;
public class Main {
	static int sumOfDigi(int n) {
         if (n < 10) {
            return n;
        } else {
            return n % 10 + sumOfDigi(n / 10);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int result = sumOfDigi(n);
        System.out.println(result);
        sc.close();
    }
}