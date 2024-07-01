import java.util.*;

class Solution {
    public int[] stockSpan(int[] a) {
        int n = a.length;
        int[] span = new int[n];
        Stack<Pair> stack = new Stack<>();
        
        stack.push(new Pair(a[0], 1));
        span[0] = 1;
        
        for (int i = 1; i < n; i++) {
            int currentSpan = 1;
            
            while (!stack.isEmpty() && a[i] >= stack.peek().val) {
                currentSpan += stack.pop().idx; 
            }
            
            stack.push(new Pair(a[i], currentSpan));
            span[i] = currentSpan; 
        }
        
        return span;
    }
}

class Pair {
    int val;
    int idx;
    
    Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        
        Solution s = new Solution();
        int ans[] = s.stockSpan(a);
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
