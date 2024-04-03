import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Binary To Decimal
        Scanner scanner = new Scanner(System.in);
        String binary = scanner.nextLine();
        
        int decimal = 0;
        int power = 0;
       
        for (int i = binary.length() - 1; i >= 0; i--) {
            int digit = binary.charAt(i) - '0';

            decimal += digit * Math.pow(2, power);
            power++;
        }
        
       System.out.println(decimal);
    }
}