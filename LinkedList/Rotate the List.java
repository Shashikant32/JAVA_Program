import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
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

    void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}

class Solution {
    static void rotateRight(Node head, int k) {
        if (head == null || k == 0) return;

        Node current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        current.next = head;

        k = k % length;
        int stepsToNewHead = length - k;
        Node newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }
        Node newHead = newTail.next;

        newTail.next = null;

        head = newHead;

        current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
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
        int k = sc.nextInt();
        Solution.rotateRight(l1.head, k);
    }
}
