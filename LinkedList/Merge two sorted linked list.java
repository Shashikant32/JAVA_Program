import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        next = null;
    }
}

class LinkedList {
    Node head;
    
    void add(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new_node;
    }
}

class Solution {
    static Node merge(Node x, Node y) {
        Node dummy = new Node(0);
        Node tail = dummy;

        Node p1 = x;
        Node p2 = y;

        while (p1 != null && p2 != null) {
            if (p1.data <= p2.data) {
                tail.next = p1;
                p1 = p1.next;
            } else {
                tail.next = p2;
                p2 = p2.next;
            }
            tail = tail.next;
        }

        if (p1 != null) {
            tail.next = p1;
        }
        if (p2 != null) {
            tail.next = p2;
        }

        return dummy.next;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList l1 = new LinkedList();
        for (int i = 0; i < n; i++) {
            l1.add(sc.nextInt());
        }
        int m = sc.nextInt();
        LinkedList l2 = new LinkedList();
        for (int i = 0; i < m; i++) {
            l2.add(sc.nextInt());
        }

        Solution ob = new Solution();
        Node head = ob.merge(l1.head, l2.head);

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
