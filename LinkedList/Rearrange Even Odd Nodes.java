import java.util.*;

class Node {
    int val;
    Node next;

    Node(int d) {
        val = d;
        next = null;
    }
}

class LinkedList {
    Node head, tail;

    void push(Node new_node) {
        if (head == null && tail == null) {
            head = tail = new_node;
            return;
        }
        tail.next = new_node;
        tail = new_node;
    }

    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class Solution {
    public Node rearrangeList(Node head) {
     if (head == null || head.next == null) {
           return head;
        }

        Node evenHead = null, evenTail = null;
        Node oddHead = null, oddTail = null;

        Node curr = head;

        while (curr != null) {
            if (curr.val % 2 == 0) {
                // Even node
                if (evenHead == null) {
                    evenHead = curr;
                    evenTail = curr;
                } else {
                    evenTail.next = curr;
                    evenTail = evenTail.next;
                }
            } else {
                // Odd node
                if (oddHead == null) {
                    oddHead = curr;
                    oddTail = curr;
                } else {
                    oddTail.next = curr;
                    oddTail = oddTail.next;
                }
            }
            curr = curr.next;
        }

        if (evenTail != null) {
            evenTail.next = oddHead;
        }

        if (oddTail != null) {
            oddTail.next = null;
        }

       return (evenHead != null) ? evenHead : oddHead;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList llist = new LinkedList();
        int h1 = sc.nextInt();
        Node head = new Node(h1);
        llist.push(head);
        for (int i = 1; i < n; i++) {
            int data = sc.nextInt();
            llist.push(new Node(data));
        }
        //llist.printList(head);
        Solution Obj = new Solution();
        head = Obj.rearrangeList(head);
        llist.printList(head);
        sc.close();
    }
}