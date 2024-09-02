import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    Node(int d) { data = d; next = null; }
}

class Insertion {
    Node head;  
    Node tail;
    
    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }
    
    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }  
        System.out.println();
    }
}

class Solution {
    public static Node reverseBetween(Node head, int m, int n) {
        if (m == n) return head;

        Node dummy = new Node(0);
        dummy.next = head;
        Node pre = dummy;

        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }

        Node start = pre.next;
        Node then = start.next;

        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        return dummy.next;
    }
}

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] S = br.readLine().split(" ");
        int N = Integer.parseInt(S[0]);
        int m = Integer.parseInt(S[1]);
        int n = Integer.parseInt(S[2]);

        String[] S1 = br.readLine().split(" ");
        Insertion llist = new Insertion(); 
        int a1 = Integer.parseInt(S1[0]);
        Node head = new Node(a1);
        llist.addToTheLast(head);
        for (int i = 1; i < N; i++) {
            int a = Integer.parseInt(S1[i]);
            llist.addToTheLast(new Node(a));
        }

        Solution ob = new Solution();
        Node newhead = ob.reverseBetween(llist.head, m, n);
        llist.printList(newhead);
    }
}
