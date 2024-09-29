import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(count(sc.nextInt()));
        sc.close();
    }

    public static long count(int n) {
        return catalan(n);
    }

    private static long catalan(int n) {
        long res = 1;
        for (int i = 0; i < n; i++) {
            res = res * (2 * (2 * i + 1)) / (i + 2);
        }
        return res;
    }
}
