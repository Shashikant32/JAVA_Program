import java.io.*;
import java.util.*;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}

class LinkedList{
    Node head;
    void add(int data ){
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
            return;
        }
        Node current = head;
        while(current.next !=null){
            current = current.next;
        }
        current.next = new_node;
    }
}

class Solution {
    public Node partition(Node head, int x) {
        Node lessThanX = new Node(0); 
        Node greaterThanOrEqualX = new Node(0); 
        Node lessThanXPtr = lessThanX;
        Node greaterThanOrEqualXPtr = greaterThanOrEqualX;

       
        Node current = head;
        while (current != null) {
            if (current.data < x) {
                lessThanXPtr.next = current;
                lessThanXPtr = lessThanXPtr.next;
            } else {
                greaterThanOrEqualXPtr.next = current;
                greaterThanOrEqualXPtr = greaterThanOrEqualXPtr.next;
            }
            current = current.next;
        }

        lessThanXPtr.next = greaterThanOrEqualX.next;
        greaterThanOrEqualXPtr.next = null; 

        return lessThanX.next;
    }
}

public class Main {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList l1= new LinkedList();
        for(int i=0;i<n;i++){
            l1.add(sc.nextInt());
        }
        int x = sc.nextInt();
        Solution Ob = new Solution();
        Node result = Ob.partition(l1.head, x);
        printList(result);
    }
    
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}
