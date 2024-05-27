import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList llist= new LinkedList(); 
        int a1=sc.nextInt();
        Node head= new Node(a1);
        llist.addToTheLast(head);
        for (int i = 1; i < n; i++) 
        {
            int a = sc.nextInt(); 
            llist.addToTheLast(new Node(a));
        }
            
        Solution A = new Solution();
        A.checkLinkedListPalindrome(llist.head);
        
    }
}

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

class LinkedList
{
    Node head;  
    Node tail;
    public void addToTheLast(Node node) 
    {
      if (head == null) 
      {
       head = node;
       tail = node;
      } 
      else 
      {
       tail.next = node;
       tail = node;
      }
    }
    
    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }   
}

class Solution
{
    static void checkLinkedListPalindrome(Node head)
    {
        //Your code here
        Node slow = head, fast = head;
        Node prev = null;
        Node midNode = null;
        boolean isPalindrome = true;

        // Find the middle node of the list and reverse the first half
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            Node temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        // If the list has odd number of elements, skip the middle node
        if (fast != null) {
            midNode = slow;
            slow = slow.next;
        }

        // Compare the first half and the reversed second half
        Node secondHalf = slow;
        while (prev != null && secondHalf != null) {
            if (prev.data != secondHalf.data) {
                isPalindrome = false;
                break;
            }
            prev = prev.next;
            secondHalf = secondHalf.next;
        }

        // Reconstruct the original list by reversing the first half back
        Node current = null;
        while (slow != null) {
            Node next = slow.next;
            slow.next = current;
            current = slow;
            slow = next;
        }

        // Connect the reversed first half with the second half
        if (midNode != null) {
            prev = current;
            current = current.next;
            prev.next = midNode;
            midNode.next = current;
        }

        if (isPalindrome) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }    
}
