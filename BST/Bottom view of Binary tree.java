import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException; // Import IOException
import java.util.*; // Import all necessary classes from java.util

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
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        // Map to store the horizontal distance and the corresponding node value
        Map<Integer, Integer> map = new TreeMap<>();
        // Queue for level order traversal
        Queue<Pair> queue = new LinkedList<>();
        // Start with root node at horizontal distance 0
        queue.add(new Pair(root, 0));
        
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            Node node = current.node;
            int hd = current.hd;
            
            // Update map with the latest node value at this horizontal distance
            map.put(hd, node.data);
            
            // Add left and right children to the queue with updated horizontal distances
            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1));
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1));
            }
        }
        
        // Collect the results from the map
        result.addAll(map.values());
        
        return result;
    }
}

// Helper class to store node and its horizontal distance
class Pair {
    Node node;
    int hd; // Horizontal distance
    
    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

class Main {
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
            Node currNode = queue.poll();
            String currVal = ip[i];
            
            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (i >= ip.length) break;
            currVal = ip[i];
            
            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution tree = new Solution();
            ArrayList<Integer> ans = tree.bottomView(root);
            
            for (Integer num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
