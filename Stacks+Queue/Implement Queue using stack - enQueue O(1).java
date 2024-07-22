import java.util.*;

class StackQueue {
    Stack<Integer> S1;
    Stack<Integer> S2;
    
    public StackQueue() {
        S1 = new Stack<>();
        S2 = new Stack<>();
    }
    
    // EnQueue operation: O(1)
    void Push(int a) {
        S1.push(a);
    }
    
    // DeQueue operation: Amortized O(1)
    int Pop() {
        if (S2.isEmpty()) {
            if (S1.isEmpty()) {
                return -1;
            }
            while (!S1.isEmpty()) {
                S2.push(S1.pop());
            }
        }
        return S2.pop();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StackQueue queue = new StackQueue();
        
        int q = scanner.nextInt();
        while (q-- > 0) {
            int queryType = scanner.nextInt();
            if (queryType == 1) {
                int a = scanner.nextInt();
                queue.Push(a);
            } else if (queryType == 2) {
                System.out.print(queue.Pop() + " ");
            }
        }
        
        scanner.close();
    }
}
