import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Star Pyramid
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        // Loop through each row
        for (int i = 0; i < n; i++) {
            // Print leading spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            
            // Print stars
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    System.out.print("* ");
                } else {
                    System.out.print("* ");
                }
            }
            
            // Move to the next line
            System.out.println();
        }
    }
}