import java.util.Scanner;

public class Main {
    public static void fun(int n, int m) {
        // Function sum
        int sum =n+m;
        System.out.print(sum);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        fun(n, m);
    }
}