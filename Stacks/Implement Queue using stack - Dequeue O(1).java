import java.util.*;

class StackQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    
    public StackQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    void Push(int x) {
        stack1.push(x);
    }

    int Pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return -1; 
        }
        return stack2.pop();
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StackQueue s = new StackQueue();
        
        int q = sc.nextInt();
        ArrayList<Integer> ans = new ArrayList<>();
        
        while (q > 0) {
            int queryType = sc.nextInt();
            if (queryType == 1) {
                int a = sc.nextInt();
                s.Push(a);
            } else if (queryType == 2) {
                int result = s.Pop();
                ans.add(result);
            }
            q--;
        }
        
        for (int x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
        
        sc.close();
    }
}
