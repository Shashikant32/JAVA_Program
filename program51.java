import java.util.*;

public class Main {
    //Count Digits
    static int numDigits(int num){
         int count = 0;
        while (num != 0) {
            num = num / 10;
            count++;
        }
        
        return count;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(numDigits(n));
    }
}
