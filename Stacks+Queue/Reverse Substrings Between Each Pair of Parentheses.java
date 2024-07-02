import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        System.out.println(reverseParentheses(s));
    }

    public static String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int n = chars.length;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else if (chars[i] == ')') {
                int start = stack.pop();
                reverseSubstring(chars, start + 1, i - 1);
            }
        }

        for (char c : chars) {
            if (c != '(' && c != ')') {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    private static void reverseSubstring(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
