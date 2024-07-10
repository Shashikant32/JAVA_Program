import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        Solution ob = new Solution();
        ob.evaluation(exp);
    }
}

class Solution {
    public void evaluation(String exp) {
        int result = evaluatePostfix(exp);
        System.out.println(result);

        String infix = postfixToInfix(exp);
        System.out.println(infix);

        String prefix = postfixToPrefix(exp);
        System.out.println(prefix);
    }

    private int evaluatePostfix(String exp) {
        Stack<Integer> stack = new Stack<>();

        for (char c : exp.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }

        return stack.pop();
    }

    private String postfixToInfix(String exp) {
        Stack<String> stack = new Stack<>();

        for (char c : exp.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(Character.toString(c));
            } else {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String result = "(" + operand1 + c + operand2 + ")";
                stack.push(result);
            }
        }

        return stack.pop();
    }

    private String postfixToPrefix(String exp) {
        Stack<String> stack = new Stack<>();

        for (char c : exp.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(Character.toString(c));
            } else {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String result = c + operand1 + operand2;
                stack.push(result);
            }
        }

        return stack.pop();
    }
}
