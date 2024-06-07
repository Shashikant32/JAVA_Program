import java.util.Scanner;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Main {
    static void printList(Node n) {
        Node curr = n;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int val = sc.nextInt();
        Node first = new Node(val);
        Node tail = first;
        for (int i = 0; i < n - 1; i++) {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        int m = sc.nextInt();
        val = sc.nextInt();
        Node second = new Node(val);
        tail = second;
        for (int i = 0; i < m - 1; i++) {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }

        Solution g = new Solution();
        Node res = g.subtract(first, second);
        printList(res);
    }
}

class Solution {
    static Node subtract(Node l1, Node l2) {
       if(isBigger(l1,l2)== false)
       {
          Node temp = l2;
           l2 = l1;
           l1 = temp;
       }
       l1= reverse(l1);
       l2= reverse(l2);
        Node dummy = new Node(-1);
        Node t= dummy;
        int borrow =0;
        while(l1 != null || l2 != null)
            {
                int ans = l1.data -borrow;
                if(l2 != null)
                {
                    ans -=l2.data;
                }
                if(ans<0)
                {
                    borrow =1;
                    ans +=10;
                }else
                {
                    borrow = 0;
                }
                t.next = new Node(ans);
                t=t.next;
                l1= l1.next;
                if(l2 !=null)
                {
                    l2 = l2.next;
                }
            }
        // remove leading zeros
        Node c=reverse(dummy.next);
        while(c != null && c.data ==0)
            {
                c=c.next;
            }
        if(c == null)
        {
            return new Node(0);
        }
        return c;
    }
    static int size(Node l)
    {
        Node temp = l;
        int n=0;
        while(temp !=null)
            {
                n++;
                temp= temp.next;
            }
        return n;
    }
    static boolean isBigger(Node l1, Node l2)
    {
        if(size(l1)>size(l2))
        {
            return true;
        }else if(size(l1)<size(l2))
        {
            return false;
        }else
        {
            Node t1 = l1;
            Node t2 = l2;
            while(t1 != null && t2 != null)
                {
                    if(t1.data > t2.data)
                    {
                        return true;
                    }else if(t1.data < t2.data)
                    {
                        return false;
                    }else
                    {
                        t1=t1.next;
                        t2=t2.next;
                    }
                }
            return true;
        }
    }
    static Node reverse(Node head)
    {
        Node curr = head;
        Node prev = null;
        while(curr != null)
            {
                Node fwd = curr.next;
                curr.next = prev;
                prev = curr;
                curr = fwd;
            }
        return prev;
    }
}
