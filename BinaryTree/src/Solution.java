//importance ******
//1110. Delete Nodes And Return Forest
 //codestorywithMIK: https://www.youtube.com/watch?v=z-pX53sYwWI
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


// Definition for a binary tree node.


public class Solution {
   
    // Main function to delete nodes and return the forest
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        // Convert to_delete array to a set for quick lookup
        Set<Integer> toDeleteSet = new HashSet<>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }
       
        // Result list to store the roots of the resulting forest
        List<TreeNode> result = new ArrayList<>();
       
        // If the root is not in the to_delete set, add it to the result list
        if (!toDeleteSet.contains(root.val)) {
            result.add(root);
        }
       
        // Perform DFS to process the tree
        dfs(root, toDeleteSet, result);
       
        return result;
    }
   
    // Helper function to perform DFS and handle node deletions
    private TreeNode dfs(TreeNode node, Set<Integer> toDeleteSet, List<TreeNode> result) {
        // Base case: if the node is null, return null
        if (node == null) {
            return null;
        }
       
        // Recursively process the left and right subtrees
        node.left = dfs(node.left, toDeleteSet, result);
        node.right = dfs(node.right, toDeleteSet, result);
       
        // If the current node needs to be deleted
        if (toDeleteSet.contains(node.val)) {
            // If the left child is not null, add it to the result list as a new tree root
            if (node.left != null) {
                result.add(node.left);
            }
            // If the right child is not null, add it to the result list as a new tree root
            if (node.right != null) {
                result.add(node.right);
            }
            // Return null to delete the current node
            return null;
        }
       
        // If the current node is not deleted, return it
        return node;
    }
   
    public static void main(String[] args) {
        // Example tree:
        //     1
        //    / \
        //   2   3
        //  / \   \
        // 4   5   6


        // Creating the tree nodes
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);


        // Nodes to delete
        int[] to_delete = {3, 5};


        // Create the solution instance and call the delNodes function
        Solution solution = new Solution();
        List<TreeNode> forest = solution.delNodes(root, to_delete);


        // Print the roots of the resulting forest
        for (TreeNode tree : forest) {
            System.out.print(tree.val + " ");
        }
        // Expected output: 1  6   // see codestorywithMIK: https://www.youtube.com/watch?v=z-pX53sYwWI
    }
}

/*
Algorithm:
	Define a helper function dfs(node, to_delete, result).
	Base case: If node is null, return null.
	Recursive case:
	Recursively call dfs on node.left and node.right.
	If node is in to_delete:
	If node.left is not null, add node.left to result.
	If node.right is not null, add node.right to result.
	Return null (this effectively deletes node).
	Otherwise, return node.
	
Main function delNodes(root, to_delete):
	Convert to_delete list to a set for O(1) look-up.
	Initialize an empty list result to store the resulting forest.
	Call dfs(root, to_delete, result).
	If the root is not deleted, add it to result.
	Return result.

*/