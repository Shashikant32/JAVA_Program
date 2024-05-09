import java.util.*;

public class Main {
    static String PairStar(String str) {
        
        if (str.length() <= 1) {
            return str;
        }
        
        if (str.charAt(0) == str.charAt(1)) {
            return str.charAt(0) + "*" + PairStar(str.substring(1));
        } else {
            return str.charAt(0) + PairStar(str.substring(1));
        }
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(PairStar(s));
    }
}