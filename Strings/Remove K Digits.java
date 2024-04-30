import java.util.*;

class Solution {
    public static String removeKdigits(String num, int k) {
        // Stack to store the digits in non-decreasing order
        Stack<Character> stack = new Stack<>();
        
        // Iterate through each digit of the number
        for (char digit : num.toCharArray()) {
            // Remove digits from stack if they are larger than the current digit and k is not yet used up
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit); // Add current digit to stack
        }
        
        // If k is still remaining, remove the remaining largest digits from the stack
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        // Construct the result string from the remaining digits in the stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop()); // Insert digits at the beginning to maintain order
        }
        
        // Remove leading zeroes
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        
        return result.toString();
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        int k = sc.nextInt();
        String result = Solution.removeKdigits(num, k);
        System.out.println(result);
        sc.close();
    }
}
