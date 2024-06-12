import java.util.*;

// A binary tree node
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
    public static void printTree(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node f = q.poll();
            System.out.print(f.data + " ");
            if (f.left != null)
                q.add(f.left);
            if (f.right != null)
                q.add(f.right);
        }
        System.out.println();
    }

    public static Node levelOrder(Node root, int value) {
        if (root == null) {
            Node nnode = new Node(value);
            return nnode;
        }
        if (value <= root.data)
            root.left = levelOrder(root.left, value);
        else
            root.right = levelOrder(root.right, value);
        return root;
    }

    public static Node constructBST(int arr[]) {
        int n = arr.length;
        if (n == 0)
            return null;
        Node root = null;
        for (int i = 0; i < n; i++)
            root = levelOrder(root, arr[i]);
        return root;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int preorder[] = new int[n];
        for (int i = 0; i < n; i++) {
            preorder[i] = (sc.nextInt());
        }
        Node root = constructBST(preorder);
        int[][] queries = new int[q][2];
        for (int i = 0; i < q; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }
        ArrayList<Integer> ans = Solution.bstQueries(root, q, queries);
        for (Integer x : ans) {
            System.out.println(x);
        }
    }
}

class Solution {
    // Helper function to perform in-order traversal and collect node values in a list
    private static void inorderTraversal(Node root, List<Integer> values) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, values);
        values.add(root.data);
        inorderTraversal(root.right, values);
    }

    public static ArrayList<Integer> bstQueries(Node root, int q, int[][] queries) {
        ArrayList<Integer> results = new ArrayList<>();
        List<Integer> values = new ArrayList<>();

        // in-order traversal
        inorderTraversal(root, values);

        for (int i = 0; i < q; i++) {
            int L = queries[i][0];
            int R = queries[i][1];

            int count = countInRange(values, L, R);
            results.add(count);
        }

        return results;
    }

    // Helper function to find the count of elements within the range [L, R]
    private static int countInRange(List<Integer> values, int L, int R) {
        int left = findLowerBound(values, L);
        int right = findUpperBound(values, R);

        if (left == -1 || right == -1 || left > right) {
            return 0;
        }
        return right - left + 1;
    }

    // Helper function to find the first index with value >= L using binary search
    private static int findLowerBound(List<Integer> values, int L) {
        int low = 0, high = values.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (values.get(mid) >= L) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (low < values.size()) ? low : -1;
    }

    // Helper function to find the last index with value <= R using binary search
    private static int findUpperBound(List<Integer> values, int R) {
        int low = 0, high = values.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (values.get(mid) <= R) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (high >= 0) ? high : -1;
    }
}
