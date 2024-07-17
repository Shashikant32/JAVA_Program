import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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

public class Main {

    static void printLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        Node ans = Obj.bstFromLevel(arr, n);
        printLevelOrder(ans);
        sc.close();
    }
}

class Solution {
    Node bstFromLevel(int arr[], int n) {
        if (n == 0) return null;

        // Create the root node from the first element of the level order array
        Node root = new Node(arr[0]);
        
        // Queue to process nodes and their valid range
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        int i = 1;
        while (!queue.isEmpty() && i < n) {
            Node currentNode = queue.poll();
            
            // Add left child
            if (i < n && arr[i] < currentNode.data) {
                currentNode.left = new Node(arr[i]);
                queue.add(currentNode.left);
                i++;
            }
            
            // Add right child
            if (i < n && arr[i] > currentNode.data) {
                currentNode.right = new Node(arr[i]);
                queue.add(currentNode.right);
                i++;
            }
        }
        
        return root;
    }
}
