import java.util.*;

class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek()[0] == c) {
                stack.peek()[1]++; 
                if (stack.peek()[1] == k) {
                    stack.pop();
                }
            } else {
                stack.push(new int[] {c, 1});
            }
        }
        StringBuilder result = new StringBuilder();
        for (int[] entry : stack) {
            char character = (char) entry[0];
            int count = entry[1];
            for (int i = 0; i < count; i++) {
                result.append(character);
            }
        }
        
        return result.toString();
    }
}
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        Solution obj = new Solution();
        System.out.println(obj.removeDuplicates(s, k));
    }
}
  