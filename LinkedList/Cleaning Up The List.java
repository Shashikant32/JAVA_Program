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

    public Node cleanLinkedList(Node head) {
        if(head == null)
        {
            return head;
        }
        Node dummy = new Node(0);
        dummy.next = head;
        
        Node prev = dummy;
        Node curr = head;
    
        while(curr != null)
            {
                boolean isDuplicate = false;
                while(curr.next != null && curr.data == curr.next.data)
                    {
                       isDuplicate= true;
                        curr = curr.next;
                    }
                if(isDuplicate)
                {
                    prev.next = curr.next;
                }else
                {
                    prev = prev.next;
                }
                curr = curr.next;
            }
        return dummy.next;
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
        Solution Ob = new Solution();
        Node ans=Ob.cleanLinkedList(l1.head);
        while(ans!=null){
            System.out.print(ans.data+" ");
            ans=ans.next;
        }

    }
}