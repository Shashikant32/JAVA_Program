import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class Main {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Main ip = new Main();
        int T = 1;
        while (T > 0) {
            int n = sc.nextInt();
            int[] inorder = new int[n];
            int[] postorder = new int[n];
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            Solution g = new Solution();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
        sc.close();
    }
}

class Solution {
    Node buildTree(int in[], int post[], int n){
        if (n == 0) return null;
        
        Node root = new Node(post[n-1]);
        
        int rootIndexInorder = 0;
        for (int i = 0; i < n; i++) {
            if (in[i] == root.data) {
                rootIndexInorder = i;
                break;
            }
        }
        
        root.left = buildTree(Arrays.copyOfRange(in, 0, rootIndexInorder),
                              Arrays.copyOfRange(post, 0, rootIndexInorder), 
                              rootIndexInorder);
        
        root.right = buildTree(Arrays.copyOfRange(in, rootIndexInorder + 1, n), 
                               Arrays.copyOfRange(post, rootIndexInorder, n - 1), 
                               n - 1 - rootIndexInorder);
        
        return root;
    }
}
