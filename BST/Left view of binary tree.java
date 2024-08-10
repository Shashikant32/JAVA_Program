import java.util.*;
import java.io.*;

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
    BST() {}

    Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        BST t = new BST();
        for (int i = 0; i < n; i++) {
            t.root = t.insert(t.root, input.nextInt());
        }
        
        Solution Accio = new Solution();
        Accio.leftView(t.root);
    }
}

class Solution {
    public static void leftView(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                Node node = queue.poll();

                if (i == 0) {
                    System.out.print(node.val + " ");
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }
}
