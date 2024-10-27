import java.util.*;

public class Main {

    public static String removeparentheses(String S, int n) {
        StringBuilder result = new StringBuilder();
        int balance = 0; // to track the depth of parentheses

        for (char ch : S.toCharArray()) {
            if (ch == '(') {
                if (balance > 0) {
                    result.append(ch);
                }
                balance++;
            } else if (ch == ')') {
                balance--;
                if (balance > 0) {
                    result.append(ch);
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        System.out.println(removeparentheses(s, n));
    }
}
