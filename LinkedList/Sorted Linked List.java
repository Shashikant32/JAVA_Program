import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList llist= new LinkedList(); 
        int a1 = sc.nextInt();
        Node head = new Node(a1);
        llist.addToTheLast(head);
        for (int i = 1; i < n; i++) {
            int a = sc.nextInt(); 
            llist.addToTheLast(new Node(a));
        }
        
        Accio A = new Accio();
        if (A.checkListSorted(llist.head)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

class Node {
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

class LinkedList {
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
    
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }  
        System.out.println();
    }
}

class Accio {
    boolean checkListSorted(Node head) {
        if (head == null) return true; 

        Node current = head;
        while (current.next != null) {
            if (current.data > current.next.data) {
                return false; 
            }
            current = current.next;
        }
        return true; 
    }
}
