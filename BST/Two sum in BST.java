import java.util.*;

class Node {
    int val;
    Node left, right;
    public Node(int item) {
        val = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node constructBST(int[] arr, int start, int end, Node root) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        if (root == null) root = new Node(arr[mid]);
        root.left = constructBST(arr, start, mid - 1, root.left);
        root.right = constructBST(arr, mid + 1, end, root.right);
        return root;
    }
}

class Solution {
    public static boolean checkTarget(Node root, int k) {
        // Use a HashSet to store the values we have seen
        Set<Integer> seenValues = new HashSet<>();
        // Call the helper method to perform the traversal and check
        return inorderTraversal(root, k, seenValues);
    }

    private static boolean inorderTraversal(Node node, int k, Set<Integer> seenValues) {
        if (node == null) return false;

        // Check the left subtree
        if (inorderTraversal(node.left, k, seenValues)) return true;

        // Check if the complement value is in the set
        int complement = k - node.val;
        if (seenValues.contains(complement)) {
            return true;
        }
        // Add the current node's value to the set
        seenValues.add(node.val);

        // Check the right subtree
        return inorderTraversal(node.right, k, seenValues);
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); 
        }
        Node root = null;
        BinarySearchTree bst = new BinarySearchTree();
        root = bst.constructBST(arr, 0, n - 1, root);
        Solution A = new Solution();
        boolean ans = A.checkTarget(root, k);
        if (ans) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
