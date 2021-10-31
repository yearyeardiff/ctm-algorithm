package org.zch.algorithm.binary_tree.BST;

/**
 * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
 * https://leetcode-cn.com/problems/legal-binary-search-tree-lcci/
 */
public class Bt合法二叉搜索树_98 {

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

    Integer preVal = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }

        if (preVal != null && root.val <= preVal) {
            return false;
        }
        preVal = root.val;

        return isValidBST(root.right);
    }
}
