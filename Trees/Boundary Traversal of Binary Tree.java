import java.util.*;

class Node {
    int data;
    Node left, right;
}

class Solution {
    static void printBoundary(Node node) {
        if (node == null) return;
        
        // Print the root node
        System.out.print(node.data + " ");
        
        // Print the left boundary (excluding leaves)
        printLeftBoundary(node.left);
        
        // Print all leaves
        printLeaves(node.left);
        printLeaves(node.right);
        
        // Print the right boundary (excluding leaves)
        printRightBoundary(node.right);
    }

    private static void printLeftBoundary(Node node) {
        if (node == null) return;
        if (node.left != null) {
            System.out.print(node.data + " ");
            printLeftBoundary(node.left);
        } else if (node.right != null) {
            System.out.print(node.data + " ");
            printLeftBoundary(node.right);
        }
        // Note: No need to print if it's a leaf node
    }

    private static void printLeaves(Node node) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            System.out.print(node.data + " ");
            return;
        }
        printLeaves(node.left);
        printLeaves(node.right);
    }

    private static void printRightBoundary(Node node) {
        if (node == null) return;
        if (node.right != null) {
            printRightBoundary(node.right);
            System.out.print(node.data + " ");
        } else if (node.left != null) {
            printRightBoundary(node.left);
            System.out.print(node.data + " ");
        }
        // Note: No need to print if it's a leaf node
    }
}

public class Main {
    static Node getNode(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.left = newNode.right = null;
        return newNode;
    }

    static Node LevelOrder(Node root, int data) {
        if (root == null) {
            root = getNode(data);
            return root;
        }
        if (data <= root.data) root.left = LevelOrder(root.left, data);
        else root.right = LevelOrder(root.right, data);
        return root;
    }

    static Node constructBst(int arr[], int n) {
        if (n == 0) return null;
        Node root = null;
        for (int i = 0; i < n; i++) root = LevelOrder(root, arr[i]);
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] tree = new int[n];
        for (int i = 0; i < n; i++) tree[i] = sc.nextInt();
        sc.close();
        Node root = constructBst(tree, n);
        Solution.printBoundary(root);
    }
}
