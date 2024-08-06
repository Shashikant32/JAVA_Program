import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

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
        String[] ip = str.split(" ");
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
            ArrayList<Integer> arr = tree.topView(root);
            for (int x : arr)
                System.out.print(x + " ");
            System.out.println();
        }
    }
}

class qObj {
    Node node;
    int level;
    qObj(Node n, int l) {
        node = n;
        level = l;
    }
}

class Solution {
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<qObj> queue = new LinkedList<>();
        queue.add(new qObj(root, 0));

        while (!queue.isEmpty()) {
            qObj current = queue.poll();
            Node node = current.node;
            int level = current.level;

            if (!map.containsKey(level)) {
                map.put(level, node.data);
            }

            if (node.left != null) {
                queue.add(new qObj(node.left, level - 1));
            }
            if (node.right != null) {
                queue.add(new qObj(node.right, level + 1));
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}
