//https://leetcode.com/problems/maximum-binary-tree/description/
public class constructMaximumBinaryTree {
	
    // Main method to construct the maximum binary tree.
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // If the input array is empty, return null.
        if (nums.length == 0) {
            return null;
        } else {
            int start = 0;
            int end = nums.length - 1;
            // Build the tree using the helper method.
            return BuildTree(nums, start, end);
        }
    }

    // Helper method to build the tree.
    public TreeNode BuildTree(int[] nums, int start, int end) {
        // Base case: if the start index is greater than the end index, return null.
        if (start > end)
            return null;

        // Find the index of the maximum element in the current range.
        int maxIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        // Create a new TreeNode with the maximum value.
        TreeNode parent = new TreeNode(nums[maxIndex]);
        // Recursively build the left subtree.
        parent.left = BuildTree(nums, start, maxIndex - 1);
        // Recursively build the right subtree.
        parent.right = BuildTree(nums, maxIndex + 1, end);

        // Return the constructed tree.
        return parent;
    }
	
	
	public static void main(String[] args) {
		constructMaximumBinaryTree sol = new constructMaximumBinaryTree();

        int[] nums1 = {3, 2, 1, 6, 0, 5};
        TreeNode tree1 = sol.constructMaximumBinaryTree(nums1);
        System.out.println("Example 1");
        printTree(tree1);

        int[] nums2 = {3, 2, 1};
        TreeNode tree2 = sol.constructMaximumBinaryTree(nums2);
        System.out.println("\n\nExample 2");
        printTree(tree2);

        int[] nums3 = {7, 4, 5, 6, 2};
        TreeNode tree3 = sol.constructMaximumBinaryTree(nums3);
        System.out.println("\n\nExample 3");
        printTree(tree3);
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }

}
