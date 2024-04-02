import java.util.*;

public class Main {

   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char ch = 'A';
    // Print Continuous Character Pattern 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                
                System.out.print(ch);
                ch=(char)(ch + 1);
                if (ch > 'Z') {
                    ch = 'A';
                }
            }
            System.out.println();
            ch = (char)('A' + i +1);
        }
    }
}