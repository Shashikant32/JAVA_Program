class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) return null;
        // Start DFS traversal with the root node
        dfs(root);
        // Set the value of the root node to 0 as per problem statement
        root.val = 0;
        return root;
    }

    private void dfs(TreeNode node) {
        // Use a queue to perform level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int sum = 0;
            List<TreeNode> currentLevel = new ArrayList<>();
            
            // Calculate the sum of the current level and store the nodes
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode);
                // Only consider children for sum
                if (currentNode.left != null) {
                    sum += currentNode.left.val;
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    sum += currentNode.right.val;
                    queue.add(currentNode.right);
                }
            }

            // Update the values of the nodes at the current level
            for (TreeNode currentNode : currentLevel) {
                int currentSum = 0;
                if (currentNode.left != null) {
                    currentSum += currentNode.left.val;
                }
                if (currentNode.right != null) {
                    currentSum += currentNode.right.val;
                }
                
                // Set the node values to the sum of cousins
                if (currentNode.left != null) {
                    currentNode.left.val = sum - currentSum;
                }
                if (currentNode.right != null) {
                    currentNode.right.val = sum - currentSum;
                }
            }
        }
    }
}
