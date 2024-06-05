import java.util.Scanner;

class Solution {
    public static Node mergesort(Node head) {
        if (head == null || head.next == null)
            return head;

        Node middle = getMiddle(head);
        Node nextToMiddle = middle.next;
        middle.next = null;

        Node left = mergesort(head);
        Node right = mergesort(nextToMiddle);

        Node sortedList = merge(left, right);
        return sortedList;
    }

    public static Node merge(Node left, Node right) {
        Node result = null;
        if (left == null)
            return right;
        if (right == null)
            return left;

        if (left.data <= right.data) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }
        return result;
    }

    public static Node getMiddle(Node head) {
        if (head == null)
            return head;

        Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

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
        Node curr = head;
        while (curr.next != null)
            curr = curr.next;
        curr.next = new_node;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        LinkedList a = new LinkedList();
        for (int i = 0; i < n; i++) {
            a.add(input.nextInt());
        }
        Solution Obj = new Solution();
        a.head = Obj.mergesort(a.head);
        Node h = a.head;
        while (h != null) {
            System.out.print(h.data + " ");
            h = h.next;
        }
    }
}
