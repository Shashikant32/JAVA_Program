import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
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
        while (queue.size() > 0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
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

    void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Node root = buildTree(s);
        Solution solution = new Solution();
        System.out.print(solution.longestUnivaluePath(root));
    }
}

class Solution {

    private int longestPath = 0;

    public int longestUnivaluePath(Node root) {
        if (root == null) return 0;
        longestPath = 0;
        findLongestPath(root);
        return longestPath;
    }

    private int findLongestPath(Node node) {
        if (node == null) return 0;

        int leftPath = findLongestPath(node.left);
        int rightPath = findLongestPath(node.right);

        int leftExtend = 0;
        int rightExtend = 0;

        if (node.left != null && node.left.data == node.data) {
            leftExtend = leftPath + 1;
        }
        if (node.right != null && node.right.data == node.data) {
            rightExtend = rightPath + 1;
        }

        longestPath = Math.max(longestPath, leftExtend + rightExtend);

        return Math.max(leftExtend, rightExtend);
    }
}
