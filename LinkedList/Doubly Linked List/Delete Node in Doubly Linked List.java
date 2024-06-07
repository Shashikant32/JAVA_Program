import java.util.*;

class Node {
    int val;
    Node prev;
    Node next;
    Node(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;
    int length;

    DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    void append(int val) {
        Node newNode = new Node(val);
        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        this.length++;
    }

    void prepend(int val) {
        Node newNode = new Node(val);
        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.head.prev = newNode;
            newNode.next = this.head;
            this.head = newNode;
        }
        this.length++;
    }

    void printList() {
        Node curr = this.head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}

class Solution {
    public static DoublyLinkedList deleteNodeWithX(DoublyLinkedList linkedList, int x) {
        Node current = linkedList.head;

        while (current != null) {
            if (current.val == x) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    linkedList.head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    linkedList.tail = current.prev;
                }
            }
            current = current.next;
        }

        return linkedList;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        DoublyLinkedList linkedList = new DoublyLinkedList();
        for (int i = 0; i < N; i++) {
            linkedList.append(sc.nextInt());
        }
        Solution Obj = new Solution();
        linkedList = Obj.deleteNodeWithX(linkedList, M);
        linkedList.printList();
    }
}
