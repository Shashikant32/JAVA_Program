import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Calculate nCr
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        
        int result = 1;

        if (r > n - r) {
            r = n - r;
        }
        for (int i = 0; i < r; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        System.out.println(result);
    }
}