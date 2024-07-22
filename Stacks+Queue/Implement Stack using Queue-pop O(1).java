import java.util.*;

class Stack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    
    public Stack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    // Push operation: O(1)
    void push(int a) {
        queue1.add(a);
    }
    
    // Pop operation: O(1) amortized
    int pop() {
        if (queue1.isEmpty())
            return -1;
        
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        
        int top = queue1.remove();
        
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        
        return top;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);    
        Stack stack = new Stack();
        int q = sc.nextInt();
        while (q > 0) {
            int queryType = sc.nextInt();
            if (queryType == 1) {
                int a = sc.nextInt();
                stack.push(a);
            } else if (queryType == 2) {
                int popped = stack.pop();
                System.out.print(popped + " ");
            }
            q--;
        }	
        sc.close();
    }
}
