import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

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
            if (!currVal.equals("-1")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (i >= ip.length) break;
            currVal = ip[i];
            if (!currVal.equals("-1")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Node root = buildTree(s);
        int x = sc.nextInt();
        int y = sc.nextInt();
        Solution g = new Solution();
        Node ans = g.findLCA(root,x,y);
        System.out.println(ans.data);
    }
}

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

class Solution {
    public static Node findLCA(Node node, int n1, int n2) {
        if (node == null) return null;

        if (node.data == n1 || node.data == n2) {
            return node;
        }

        Node leftLCA = findLCA(node.left, n1, n2);
        Node rightLCA = findLCA(node.right, n1, n2);

        if (leftLCA != null && rightLCA != null) {
            return node;
        }

        return (leftLCA != null) ? leftLCA : rightLCA;
    }
}
