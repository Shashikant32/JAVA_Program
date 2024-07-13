import java.util.*;

class Node {
    int val;
    Node left, right;
    
    Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

class BST {
    Node root = null;
    
    BST() {
        
    }
    
    BST(Node root) {
        this.root = root;
    }
    
    Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }
        return root;
    }
    
    void print(Node root) {
        if (root != null) {
            System.out.print(root.val + " ");
            print(root.left);
            print(root.right);
        }
    }
}

class Solution {
    Node findSuccessor(Node root) {
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    
    Node deleteNode(Node root, int val) {
        if (root == null) {
            return null;
        }
        
        if (val < root.val) {
            root.left = deleteNode(root.left, val);
        } else if (val > root.val) {
            root.right = deleteNode(root.right, val);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            
            Node successor = findSuccessor(root.right);
            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
        }
        return root;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), k = input.nextInt();
        BST t = new BST();
        
        for (int i = 0; i < n; i++) {
            t.root = t.insert(t.root, input.nextInt());
        }
        
        Solution obj = new Solution();
        t.root = obj.deleteNode(t.root, k);
        
        t.print(t.root);
    }
}
