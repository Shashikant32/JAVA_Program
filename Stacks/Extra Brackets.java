import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Solution {
    public boolean extraBrackets(String exp) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : exp.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    return true; 
                }
                while (!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop();
                }
                
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return true; 
                }
            } else {
                stack.push(c);
            }
        }
        
        return false; 
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        
        Solution obj = new Solution();
        if (obj.extraBrackets(exp)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
