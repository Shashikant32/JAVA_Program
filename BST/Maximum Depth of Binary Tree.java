import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;

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
    
    // Function to build a binary tree from a level-order input string
    static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }
        
        String[] ip = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root);
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            Node currNode = queue.poll();  // Dequeue the front node
            
            // Assign the left child
            String currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (i >= ip.length)
                break;
            
            // Assign the right child
            currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }

    // In-order traversal to print the binary tree
    static void printInorder(Node root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution ob = new Solution();
            System.out.println(ob.height(root));
            t--;
        }
    }
}

class Solution {
    // Method to find the height of the binary tree
    int height(Node node) {
        if (node == null) {
            return 0;
        }
        // Compute the depth of each subtree and add 1 for the root
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
