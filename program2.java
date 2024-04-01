import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        char ch = scr.next().charAt(0);
        int result=0;
        //Which Case
        if(ch>='A' && ch<='Z')  // if the character is a Uppercase alphabet(A to Z) print 1
        {
            result=1;
        }else if(ch>= 'a' && ch<='z')  // if the character is a Lowercase alphabet(a to z) print 0 
        {
            result =0;
        }else               // if the character is not an Alphabet then print -1
        {
            result =-1;
        }
        System.out.println(result);
    }
}