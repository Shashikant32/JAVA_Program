import java.util.*;

class Node {
    int data;
    Node left, right;
    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinarySearchTree {
    // Method to construct the BST from the sorted array
    Node constructBST(int[] arr, int start, int end, Node root) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;

        if (root == null)
            root = new Node(arr[mid]);

        root.left = constructBST(arr, start, mid - 1, root.left);
        root.right = constructBST(arr, mid + 1, end, root.right);

        return root;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr); // Sort the array to get the BST from sorted array
        Node root = null;
        BinarySearchTree bst = new BinarySearchTree();
        root = bst.constructBST(arr, 0, n - 1, root);

        Solution accio = new Solution();
        Node ans = accio.LCA(root, p, q);
        System.out.println(ans.data);
        sc.close();
    }
}

class Solution {
    Node LCA(Node node, int n1, int n2) {
        if (node == null) {
            return null;
        }
        
        if (n1 < node.data && n2 < node.data) {
            return LCA(node.left, n1, n2);
        }

        if (n1 > node.data && n2 > node.data) {
            return LCA(node.right, n1, n2);
        }

        return node;
    }
}
