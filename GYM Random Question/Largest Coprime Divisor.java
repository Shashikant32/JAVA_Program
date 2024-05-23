import java.util.*;

public class Main {
    public static int cpFact(int A, int B) {
        while (gcd(A, B) != 1) {
            int gcdAB = gcd(A, B);
            A = A / gcdAB;
        }
        return A;
    }
    
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        System.out.print(cpFact(A, B));
    }
}
