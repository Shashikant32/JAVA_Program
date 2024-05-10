import java.io.*;
import java.util.Scanner;

public class Main {

    static boolean isPalindrome(String str){
        if(str.length()<=1)
        {
            return true;
        }
        if(str.charAt(0) != str.charAt(str.length()-1))
        {
            return false;
        }
        return isPalindrome(str.substring(1, str.length()-1));
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str= sc.nextLine();
        boolean result=isPalindrome(str);
        if(result)
            System.out.print("YES");
        else
            System.out.print("NO");
    }
}