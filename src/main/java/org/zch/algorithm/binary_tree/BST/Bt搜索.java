package org.zch.algorithm.binary_tree.BST;

public class Bt搜索 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isInBST(TreeNode root, int target) {
        if (root == null) return false;
        if (root.val == target) return true;
        if (root.val < target)
            return isInBST(root.right, target);
        return isInBST(root.left, target);
    }
}
