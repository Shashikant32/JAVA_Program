import java.util.*;
class Node {
    int data;
    Node next;
    Node(int key) {
        data = key;
        next = null;
    }
}

class Solution {
    public Node rearrange(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        // Step 1: Split the list into two halves
        Node firstHalf = head;
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node secondHalf = slow.next;
        slow.next = null;
        
        // Step 2: Reverse the second half of the list
        secondHalf = reverse(secondHalf);
        
        // Step 3: Interleave the nodes of the first and reversed second half
        Node dummy = new Node(0);
        Node current = dummy;
        while (firstHalf != null || secondHalf != null) {
            if (firstHalf != null) {
                current.next = firstHalf;
                current = current.next;
                firstHalf = firstHalf.next;
            }
            if (secondHalf != null) {
                current.next = secondHalf;
                current = current.next;
                secondHalf = secondHalf.next;
            }
        }
        
        return dummy.next;
    }
    
    private Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}

public class Main {
    public static void main(String[] args) {
        // Example usage
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0){
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;
            
            for(int i = 1; i < n; i++){
                int data = sc.nextInt();
                temp.next = new Node(data);
                temp = temp.next;
            }
            
            Solution solution = new Solution();
            Node node = solution.rearrange(head);
            printList(node);
            System.out.println();
        }
    }
    
    public static void printList(Node node){
        while(node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
