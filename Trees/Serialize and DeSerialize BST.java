import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void preOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }

    static int itr = 0;

    public static TreeNode construct(String[] preOrderSplit) {
        if (itr >= preOrderSplit.length || preOrderSplit[itr].equals("null")) {
            itr++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(preOrderSplit[itr]));
        itr++;
        root.left = construct(preOrderSplit);
        root.right = construct(preOrderSplit);

        return root;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String str) {
        String[] preOrderSplit = str.split(",");
        return construct(preOrderSplit);
    }

    // Utility function to display the tree
    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);
    }

    // Utility function to create tree from array
    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] >= arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]]);
        IDX[0]++;
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        String s = serialize(root);
        display(deserialize(s));
    }

    public static void main(String[] args) {
        solve();
    }
}