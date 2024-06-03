import java.util.*;
import java.io.*;

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

class Solution {
    Node swapkthnode(Node head, int num, int K) {
        if (head == null || K > num)
            return head;

        if (2 * K - 1 == num)
            return head;

        Node prevX = null;
        Node currX = head;
        for (int i = 1; i < K && currX != null; i++) {
            prevX = currX;
            currX = currX.next;
        }

        Node prevY = null;
        Node currY = head;
        for (int i = 1; i < num - K + 1 && currY != null; i++) {
            prevY = currY;
            currY = currY.next;
        }

        if (currX == null || currY == null)
            return head;

        if (prevX != null)
            prevX.next = currY;
        else
            head = currY;

        if (prevY != null)
            prevY.next = currX;
        else
            head = currX;

        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;

        return head;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        LinkedList list = new LinkedList();
        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            list.add(x);
        }
        Solution obj = new Solution();
        list.head = obj.swapkthnode(list.head, n, k);
        Node curr = list.head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
