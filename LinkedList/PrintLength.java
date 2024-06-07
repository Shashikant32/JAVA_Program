import java.util.*;

class Node{
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        next = null;
    }
}
class LinkedList{
    Node head;

    public void print() {
        Node curr = head;
        while(curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("Null");
    }

    public void add(int val) {
        Node new_node = new Node(val);

        if(head == null) {
            head = new_node;
            return;
        }
        
        Node curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = new_node;
    }
   public int Length()
   {
       int count=0;
       Node curr=head;
       while(curr != null)
       {
           count++;
           curr = curr.next;
       }
       return count;
   }
}

public class Main{
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.print();
        System.out.println(list.Length());
    }
}
