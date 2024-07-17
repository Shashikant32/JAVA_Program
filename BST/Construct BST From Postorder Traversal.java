import java.util.Scanner;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode CreateTree(int n, int[] postOrder) {
        if (n == 0) return null;
        return buildTree(postOrder, 0, n - 1);
    }

    private static TreeNode buildTree(int[] postOrder, int start, int end) {
        if (start > end) return null;
        
        // The last element in the current range is the root
        TreeNode root = new TreeNode(postOrder[end]);
        
        // Find the boundary for right subtree (first element greater than root)
        int splitIndex = start;
        while (splitIndex < end && postOrder[splitIndex] < root.val) {
            splitIndex++;
        }
        
        // Build right subtree first
        root.right = buildTree(postOrder, splitIndex, end - 1);
        
        // Build left subtree
        root.left = buildTree(postOrder, start, splitIndex - 1);
        
        return root;
    }

    public static void display(TreeNode node) {
        if (node == null) return;
        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append("->" + node.val + "<-");
        sb.append((node.right != null ? node.right.val : "."));
        System.out.println(sb.toString());
        display(node.left);
        display(node.right);
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] post = new int[n];
        for (int i = 0; i < n; i++)
            post[i] = scn.nextInt();

        TreeNode root = CreateTree(n, post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
