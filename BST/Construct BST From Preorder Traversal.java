import java.util.Scanner;

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
     public static TreeNode f(int[] p, int psi, int pei)
    {
        if(psi>pei) return null;
        TreeNode root = new TreeNode(p[psi]);
        int ind = psi +1;
        while(ind <= pei && p[psi]> p[ind]) ind++;
        root.left = f(p, psi+1, ind-1);
        root.right = f(p, ind ,pei);
        return root;
    }
    public static TreeNode CreateTree(int n,int[] preOrder) {
       return f(preOrder,0,preOrder.length-1);
    }

    // input_section=================================================

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
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = CreateTree(n,pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}