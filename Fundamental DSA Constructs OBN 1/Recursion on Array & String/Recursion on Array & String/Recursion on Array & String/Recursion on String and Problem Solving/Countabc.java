import java.util.*;

public class Main {
    static int CountABC(String str, int i) {
        if (i >= str.length() - 2)
            return 0;

        
        if (str.substring(i, i + 3).equals("abc") || str.substring(i, i + 3).equals("aba")) {
            return 1 + CountABC(str, i + 1);
        } else {
            return CountABC(str, i + 1); 
        }
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(CountABC(s, 0));

    }
}