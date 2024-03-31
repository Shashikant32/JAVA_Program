import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        char ch = scr.next().charAt(0);
        int result=0;

        if(ch>='A' && ch<='Z')
        {
            result=1;
        }else if(ch>= 'a' && ch<='z')
        {
            result =0;
        }else
        {
            result =-1;
        }
        System.out.println(result);
    }
}