import java.util.*;
import java.lang.*;
import java.io.*;
class Main {
   
    public static String reverseWords(String s)
    {
         String[] words = s.split(" ");
        
        StringBuilder reversed = new StringBuilder();
        
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) {
                reversed.append(" ");
            }
        }
        
        return reversed.toString();
    } 
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String p = sc.nextLine();
        while (t > 0) {
            String s = sc.nextLine();
            System.out.println(reverseWords(s));
            t--;
        }
    }
}