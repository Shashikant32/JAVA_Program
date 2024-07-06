import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) arr[i] = sc.next();
        int k = sc.nextInt();
        sc.close();
        Node tree = levelOrderCreateTree(arr);
        System.out.println(timeToBurnTree(tree, k));
    }

    public static int timeToBurnTree(Node root, int start) {
        Map<Node, Node> childParentMap = new HashMap<>();
        prepareMapping(root, childParentMap);

        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        Node startNode = findNode(root, start);

        queue.offer(startNode);
        visited.add(startNode);
        int maxTime = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundNewNodes = false;

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                // Check left child
                if (node.left != null && !visited.contains(node.left)) {
                    queue.offer(node.left);
                    visited.add(node.left);
                    foundNewNodes = true;
                }

                // Check right child
                if (node.right != null && !visited.contains(node.right)) {
                    queue.offer(node.right);
                    visited.add(node.right);
                    foundNewNodes = true;
                }

                // Check parent
                Node parent = childParentMap.get(node);
                if (parent != null && !visited.contains(parent)) {
                    queue.offer(parent);
                    visited.add(parent);
                    foundNewNodes = true;
                }
            }

            if (foundNewNodes) {
                maxTime++;
            }
        }

        return maxTime;
    }

    private static Node findNode(Node root, int start) {
        if (root == null) {
            return null;
        }

        if (root.data == start) {
            return root;
        }

        Node left = findNode(root.left, start);
        if (left != null) {
            return left;
        }

        return findNode(root.right, start);
    }

    private static void prepareMapping(Node root, Map<Node, Node> childParentMap) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            childParentMap.put(root.left, root);
            prepareMapping(root.left, childParentMap);
        }

        if (root.right != null) {
            childParentMap.put(root.right, root);
            prepareMapping(root.right, childParentMap);
        }
    }

    static void createTree(Node node, int i, String[] arr) {
    if (node != null) {
        if (2 * i + 1 < arr.length) {
            if (arr[2 * i + 1].equals("null")) {
                node.left = null;
            } else {
                node.left = new Node(Integer.parseInt(arr[2 * i + 1]));
            }
            createTree(node.left, 2 * i + 1, arr);
        }
        if (2 * i + 2 < arr.length) {
            if (arr[2 * i + 2].equals("null")) {
                node.right = null;
            } else {
                node.right = new Node(Integer.parseInt(arr[2 * i + 2]));
            }
            createTree(node.right, 2 * i + 2, arr);
        }
    }
}


    static Node levelOrderCreateTree(String[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(Integer.parseInt(arr[0]));
        createTree(head, 0, arr);
        return head;
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
