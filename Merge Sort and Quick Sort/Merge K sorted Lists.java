import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class LinkedList {
    Node head;
    Node tail;

    LinkedList() {
        head = null;
        tail = null;
    }

    void addToTheLast(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }
}

public class Main {
    public static Node kSortedlist(List<Node> lists) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.data - b.data);

        // Add heads of all lists to minHeap
        for (Node node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }

        Node dummyHead = new Node(0);
        Node curr = dummyHead;

        // Poll from minHeap and add to result linked list
        while (!minHeap.isEmpty()) {
            Node smallest = minHeap.poll();
            curr.next = smallest;
            curr = curr.next;

            if (smallest.next != null) {
                minHeap.add(smallest.next);
            }
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        List<Node> lists = new ArrayList<>();

        while (k-- > 0) {
            int n = sc.nextInt();
            LinkedList l = new LinkedList();

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                Node temp = new Node(x);
                l.addToTheLast(temp);
            }

            lists.add(l.head);
        }

        Node ans = kSortedlist(lists);

        while (ans != null) {
            System.out.print(ans.data + " ");
            ans = ans.next;
        }

        System.out.println();
    }
}
