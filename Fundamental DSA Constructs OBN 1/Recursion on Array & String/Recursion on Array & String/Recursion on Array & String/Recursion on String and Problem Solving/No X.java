import java.util.*;

public class Main {
    static String noX(String s) 
    {
           if (s.length() == 0) 
           {
            return "";
        }

        char firstChar = s.charAt(0);
        if (firstChar == 'x') {
            return noX(s.substring(1));
        } else {
            return firstChar + noX(s.substring(1));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        System.out.println(noX(s));
    }
}