import java.util.*;
import java.util.Scanner;

public class Main{
    static void printSubsequence(String s) {
        helper(s,0,"");
    }
    static void helper(String s ,int i, String ans)
    {
        if(i==s.length())
        {
            System.out.print(ans + " ");
            return;
        }
        // optinon one --> jayega
        helper(s,i+1,ans+s.charAt(i));

        //option two --> nahi jayega

        helper(s,i+1,ans);
        
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        printSubsequence(s);
    }
}