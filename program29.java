import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Automorphic Number
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();
        scanner.close();

        if (isAutomorphic(N)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    public static boolean isAutomorphic(long N) {
        long square = N * N;
        while (N > 0) {
            if (N % 10 != square % 10) {
                return false;
            }
            N /= 10;
            square /= 10;
        }
        return true;
    }
}