import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Place Value Checker
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        boolean res = SecondLastDigit(n);
        if (res)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    public static boolean SecondLastDigit(int n) {
        // write code here
        String strN =Integer.toString(n);
        if(strN.length() < 2)
        {
            return false;
        }
        char LastDigit = strN.charAt(strN.length() - 2);
         return LastDigit == '0';
    }
}