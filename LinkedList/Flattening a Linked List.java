import java.util.*;
public class Main {
  static class Node {
    int data;
    Node right, down;
    Node(int data) {
      this.data = data;
      right = null;
      down = null;
    }
  }
static Node merge(Node a, Node b)
    {
        if(a== null)
        {
            return b;
        }
        if(b==null)
        {
            return a;
        }
        Node result = null;
        if(a.data < b.data)
        {
            result = a;
            result.down = merge(a.down,b);
        }else
        {
            result = b;
            result.down = merge(a,b.down);
        }
        result.right = null;
        return result;
    }
  static Node flatten(Node root) {
    if(root == null || root.right == null)
    {
        return root;
    }
      root.right = flatten(root.right);
      root = merge(root,root.right);
      return root;
  }

static void printList(Node head) {
    Node curr = head;
    while(curr != null)
        {
            System.out.print(curr.data + " ");
            curr = curr.down;
        }
    System.out.println();
  }

  public static boolean isCorrect(Node claim) {
    if (claim.right != null) return false;
    Node copy = claim;
    while (copy.down != null) {
      if (copy.down.data < copy.data) return false;
      copy = copy.down;
    }
    return true;
  }

  // Driver's code
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Node ll = new Node(-1), prev1 = null, head = ll;
    for (int i = 0; i < n; i++) {
      int k = sc.nextInt();
      Node prev2 = null, copy = ll;
      while (k-- != 0) {
        int val = sc.nextInt();
        copy.data = val;
        copy.down = new Node(-1);
        prev2 = copy;
        copy = copy.down;
      }
      prev2.down = null;
      ll.right = new Node(-1);
      prev1 = ll;
      ll = ll.right;
    }
    sc.close();
    prev1.right = null;
    Node flattenedNode = flatten(head);
    printList(flattenedNode);
    if (isCorrect(flattenedNode)) System.out.println(
      "yes"
    ); else System.out.println("no");
  }
}