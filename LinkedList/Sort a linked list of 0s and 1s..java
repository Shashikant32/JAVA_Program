import java.util.*;

class Solution {
    static LinkedListNode sort01(LinkedListNode head){
        if (head == null || head.next == null) {
            return head; 
        }
        
        LinkedListNode zeroDummy = new LinkedListNode(0); 
        LinkedListNode oneDummy = new LinkedListNode(0);  
        LinkedListNode zeroTail = zeroDummy; 
        LinkedListNode oneTail = oneDummy;  
        
        LinkedListNode current = head;
        
        while (current != null) {
            if (current.data == 0) {
                zeroTail.next = current;
                zeroTail = zeroTail.next;
            } else { 
                oneTail.next = current;
                oneTail = oneTail.next;
            }
            current = current.next;
        }
        
       
        zeroTail.next = oneDummy.next;
       
        oneTail.next = null;
        
       
        return zeroDummy.next;
    }
}

class LinkedListNode  {
    int data;
    LinkedListNode next;

    public LinkedListNode(int data)  {
        this.data = data;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedListNode head = new LinkedListNode(sc.nextInt());
        LinkedListNode a = head;
        for(int i=1;i<n;i++) {
            LinkedListNode temp = new LinkedListNode(sc.nextInt());
            a.next = temp;
            a = temp;
        }
        LinkedListNode ans = Solution.sort01(head);
        for(int i=0;i<n;i++) {
            if(i == n-1) {
                System.out.println(ans.data);
            }
            else {
                System.out.print(ans.data + " ");
            }
            ans = ans.next;
        }
    }
}