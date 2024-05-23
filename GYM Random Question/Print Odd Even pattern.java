import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();
        
        printOddEvenPattern(N);
    }
    
    public static void printOddEvenPattern(int N) {
        for (int i = 1; i <= N; i++) {
            if (i % 4 == 1 || i % 4 == 2) {
                System.out.print(i + " ");
            }
        }
    }

}
