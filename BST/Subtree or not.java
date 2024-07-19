import java.util.LinkedList;
import java.util.Queue;
import java.io.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Main {

    static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < ip.length) {
            Node currNode = queue.poll();

            String currVal = ip[i];

            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }

            i++;
            if (i >= ip.length)
                break;

            currVal = ip[i];

            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String tt = br.readLine();
            Node rootT = buildTree(tt);

            String s = br.readLine();
            Node rootS = buildTree(s);

            Solution solution = new Solution();
            boolean isSubtree = solution.isSubtree(rootT, rootS);

            System.out.println(isSubtree ? "true" : "false");
        }
    }
}

class Solution {
    public boolean isSubtree(Node s, Node t) {
        if (s == null)
            return false;
        if (isIdentical(s, t))
            return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isIdentical(Node s, Node t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        return (s.data == t.data && isIdentical(s.left, t.left) && isIdentical(s.right, t.right));
    }
}
