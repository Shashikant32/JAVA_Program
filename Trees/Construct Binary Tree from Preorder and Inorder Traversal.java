import java.util.*;

class Node {
    int data; 
    Node left, right;
    Node(int key) {
        data = key;
        left = right = null;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node root = null;
        int inorder[] = new int[n];
        int preorder[] = new int[n];
        for (int i = 0; i < n; i++)
            preorder[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            inorder[i] = sc.nextInt();
        Solution ob = new Solution();
        root = ob.buildTree(inorder, preorder, n);
        postOrder(root);
        System.out.println();
    }
    
    public static void postOrder(Node root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}

class Solution {
    public Node buildTree(int inorder[], int preorder[], int n) {
        return construct(preorder, 0, n - 1, inorder, 0, n - 1);
    }
    
    public Node construct(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd)
            return null;
        
        Node root = new Node(preorder[preStart]);
        
        // Find index of current root in inorder traversal
        int rootIndex = inStart;
        while (rootIndex <= inEnd && inorder[rootIndex] != preorder[preStart]) {
            rootIndex++;
        }
        
        int numberOfNodesLeftSubtree = rootIndex - inStart;
        
        root.left = construct(preorder, preStart + 1, preStart + numberOfNodesLeftSubtree,
                              inorder, inStart, rootIndex - 1);
        
        root.right = construct(preorder, preStart + numberOfNodesLeftSubtree + 1, preEnd,
                               inorder, rootIndex + 1, inEnd);
        
        return root;
    }
}
