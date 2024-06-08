import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class ClosestElementInBinarySearchTree {
    static int closestValue(TreeNode root, int target) {
        if (root == null) return -1;
        
        TreeNode current = root;
        int closest = root.val;
        
        while (current != null) {
            if (Math.abs(current.val - target) < Math.abs(closest - target)) {
                closest = current.val;
            }
            
            if (current.val == target) {
                return current.val;
            } else if (current.val < target) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        
        return closest;
    }

    static TreeNode buildTree(String[] nodes) {
        if (nodes.length == 0) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);

        for (int i = 1; i < nodes.length; i += 2) {
            TreeNode parent = queue.poll();
            if (!nodes[i].equals("N")) {
                parent.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(parent.left);
            }
            if (i + 1 < nodes.length && !nodes[i + 1].equals("N")) {
                parent.right = new TreeNode(Integer.parseInt(nodes[i + 1]));
                queue.offer(parent.right);
            }
        }

        return root;
    }

    static void levelOrderTraversal(TreeNode root) {
        if (root == null) return;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");
            
            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nodes = sc.nextLine().split("\\s+");
        int target = Integer.parseInt(sc.nextLine());
        
        TreeNode root = buildTree(nodes);
        int closest = closestValue(root, target);
        System.out.println(closest);
        
        sc.close();
    }
}

