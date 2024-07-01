import java.util.*;

class Node {
    int value;
    Node next;
    
    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}

class Queue {
    private Node front;
    private Node rear;
    private int size;
    
    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }
    
    public int pop() {
        if (front == null) {
            return -1; 
        }
        int popped = front.value;
        front = front.next;
        if (front == null) {
            rear = null; 
        }
        size--;
        return popped;
    }
    
    public int front() {
        if (front == null) {
            return -1; // Queue is empty
        }
        return front.value;
    }
    
    public int getSize() {
        return size;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue q = new Queue();
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            int op = sc.nextInt();
            if (op == 1) {
                int x = sc.nextInt();
                q.push(x);
            } else if (op == 2) {
                System.out.println(q.pop());
            } else if (op == 3) {
                System.out.println(q.front());
            } else if (op == 4) {
                System.out.println(q.getSize());
            }
        }
        
        sc.close();
    }
}
