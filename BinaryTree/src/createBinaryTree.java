//https://leetcode.com/problems/create-binary-tree-from-descriptions/

import java.util.HashMap;
import java.util.HashSet;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class createBinaryTree {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> hm = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        TreeNode grandNode = new TreeNode();

        for (int[] info : descriptions) {
            int parent = info[0];
            int child = info[1];
            int left = info[2];

            if (!hm.containsKey(parent)) {
                hm.put(parent, new TreeNode(parent));
            }

            if (!hm.containsKey(child)) {
                hm.put(child, new TreeNode(child));
            }

            if (left == 1) {
                TreeNode parentNode = hm.get(parent);
                TreeNode childNode = hm.get(child);
                parentNode.left = childNode;
            } else {
                TreeNode parentNode = hm.get(parent);
                TreeNode childNode = hm.get(child);
                parentNode.right = childNode;
            }

            set.add(child);
        }

        for (int[] info : descriptions) {
            int parent = info[0];
            if (set.contains(parent)) {
                continue;
            } else {
                TreeNode parentNode = hm.get(parent);
                grandNode = parentNode;
            }
        }
        return grandNode;
    }

    // Helper method to print the tree (Preorder Traversal)
    public static void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        printTree(node.left);
        printTree(node.right);
    }

    public static void main(String[] args) {
    	createBinaryTree solution = new createBinaryTree();

        // Example 1
        int[][] descriptions1 = {
            {1, 2, 1},
            {1, 3, 0},
            {2, 4, 1}
        };
        TreeNode root1 = solution.createBinaryTree(descriptions1);
        System.out.print("Example 1: ");
        printTree(root1);
        System.out.println();

        // Example 2
        int[][] descriptions2 = {
            {3, 1, 1},
            {3, 2, 0},
            {1, 4, 1},
            {1, 5, 0}
        };
        TreeNode root2 = solution.createBinaryTree(descriptions2);
        System.out.print("Example 2: ");
        printTree(root2);
        System.out.println();

        // Example 3
        int[][] descriptions3 = {
            {5, 3, 1},
            {5, 6, 0},
            {3, 1, 1},
            {3, 2, 0}
        };
        
        TreeNode root3 = solution.createBinaryTree(descriptions3);
        System.out.print("Example 3: ");
        printTree(root3);
        System.out.println();

        // Example 4
        int[][] descriptions4 = {
            {4, 2, 1},
            {4, 7, 0},
            {2, 1, 1},
            {2, 3, 0},
            {7, 6, 1},
            {7, 9, 0}
        };
        TreeNode root4 = solution.createBinaryTree(descriptions4);
        System.out.print("Example 4: ");
        printTree(root4);
        System.out.println();

        // Example 5
        int[][] descriptions5 = {
            {10, 5, 1},
            {10, 15, 0},
            {5, 3, 1},
            {5, 7, 0},
            {15, 12, 1},
            {15, 18, 0}
        };
        TreeNode root5 = solution.createBinaryTree(descriptions5);
        System.out.print("Example 5: ");
        printTree(root5);
        System.out.println();
    }
}
