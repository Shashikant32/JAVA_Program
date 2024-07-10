import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        valueOfExpression(str);
        scn.close();
    }

    public static void valueOfExpression(String str) {
        int result = evaluatePrefix(str);
        System.out.println(result);

        String infix = prefixToInfix(str);
        System.out.println(infix);

        String postfix = prefixToPostfix(str);
        System.out.println(postfix);
    }

    private static int evaluatePrefix(String exp) {
        Stack<Integer> stack = new Stack<>();

        for (int i = exp.length() - 1; i >= 0; i--) {
            char c = exp.charAt(i);
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int operand1 = stack.pop();
                int operand2 = stack.pop();
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

    private static String prefixToInfix(String exp) {
        Stack<String> stack = new Stack<>();

        for (int i = exp.length() - 1; i >= 0; i--) {
            char c = exp.charAt(i);
            if (Character.isDigit(c)) {
                stack.push(Character.toString(c));
            } else {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String result = "(" + operand1 + c + operand2 + ")";
                stack.push(result);
            }
        }

        return stack.pop();
    }

    private static String prefixToPostfix(String exp) {
        Stack<String> stack = new Stack<>();

        for (int i = exp.length() - 1; i >= 0; i--) {
            char c = exp.charAt(i);
            if (Character.isDigit(c)) {
                stack.push(Character.toString(c));
            } else {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String result = operand1 + operand2 + c;
                stack.push(result);
            }
        }

        return stack.pop();
    }
}
