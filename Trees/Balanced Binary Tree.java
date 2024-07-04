import java.util.*;

public class Main {

    static class Node {
        int data;
        Node left, right;
    }

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
        if (data <= root.data)
            root.left = LevelOrder(root.left, data);
        else
            root.right = LevelOrder(root.right, data);
        return root;
    }

    static Node constructBst(int arr[], int n) {
        Node root = null;
        for (int i = 0; i < n; i++)
            root = LevelOrder(root, arr[i]);
        return root;
    }

    public static boolean isBalanced(Node root) {
        if (root == null)
            return true;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // Check if the subtree heights differ by more than 1
        if (Math.abs(leftHeight - rightHeight) > 1)
            return false;

        // Recursively check if left and right subtrees are balanced
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int getHeight(Node root) {
        if (root == null)
            return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] tree = new int[n];
        for (int i = 0; i < n; i++)
            tree[i] = sc.nextInt();
        sc.close();
        
        Node root = constructBst(tree, n);
        if (isBalanced(root))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
