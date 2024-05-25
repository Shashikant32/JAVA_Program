import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        LinkedList ll = new LinkedList();
        int n = input.nextInt();
        for(int i = 0; i < n; i++){
            int x = input.nextInt();
            ll.add(x);
        }

        int size = n;
        int toRemove = input.nextInt();
        Solution s = new Solution();
        s.remove(ll, toRemove);
        printLinkedList(ll);
    }

    public static void printLinkedList(LinkedList ll) {
        Node temp = ll.head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
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
        if(head == null){
            head = new_node;
            return;
        }
        Node curr = head;
        while(curr.next != null)
            curr = curr.next;
        curr.next = new_node;
    }
}

class Solution {
    public static void remove(LinkedList ll, int toRemove) {
        Node head = ll.head;
        if(head == null)
            return;
        if(toRemove == 0) {
            ll.head = head.next;
            return;
        }
        Node temp = head;
        for(int i = 0; i < toRemove - 1; i++) {
            if(temp == null || temp.next == null)
                return;
            temp = temp.next;
        }
        if(temp == null || temp.next == null)
            return;
        temp.next = temp.next.next;
    }
}
