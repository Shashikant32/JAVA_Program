import java.util.Scanner;

public class Main {  
   public static void main(String[] args) {
    // Number Rotation
        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();
        int k = scanner.nextInt();
        rotateNumber(number, k);
    }

    public static void rotateNumber(String number, int k) {
        int len = number.length();
        k %= len;

        if (k == 0) {
            System.out.println(number);
        } else {
            if (k > 0) {
                String rotatedNumber = number.substring(len - k) + number.substring(0, len - k);
                System.out.println(rotatedNumber);
            } else {
                k *= -1;
                String rotatedNumber = number.substring(k) + number.substring(0, k);
                System.out.println(rotatedNumber);
            }
        }
    }
}