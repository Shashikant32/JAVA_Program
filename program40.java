import java.util.*;

class Main {
    public static void main(String[] args){
        //Armstrong Number Finder
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
         if (isArmstrong(N)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
     }

public static boolean isArmstrong(int N) {
        int originalNumber = N;
        int sum = 0;
        while (N > 0) {
            int digit = N % 10;
            sum += digit * digit * digit;
            N /= 10;
        }
        return originalNumber == sum;
    }
}