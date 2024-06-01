import java.util.*;
import java.io.*;
import java.lang.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class Main {
    public static void makeLoop(Node head, Node tail, int x) {
        if (x == 0)
            return;

        Node curr = head;
        for (int i = 1; i < x; i++)
            curr = curr.next;

        tail.next = curr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int num = sc.nextInt();
        Node head = new Node(num);
        Node tail = head;

        for (int i = 0; i < n - 1; i++) {
            num = sc.nextInt();
            tail.next = new Node(num);
            tail = tail.next;
        }

        int pos = sc.nextInt();
        makeLoop(head, tail, pos);

        Solution x = new Solution();
        Node y = x.detectLoop(head);
        if (y == null)
            System.out.println(0);
        else
            System.out.println(y.data);
    }
}

class Solution {
    public Node detectLoop(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        // Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow; // Node where cycle begins
    }
}
