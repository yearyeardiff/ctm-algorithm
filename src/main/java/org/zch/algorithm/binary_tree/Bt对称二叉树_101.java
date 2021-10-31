package org.zch.algorithm.binary_tree;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class Bt对称二叉树_101 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public boolean isSymmetric(TreeNode root) {
        if(root==null) {
            return true;
        }
        //调用递归函数，比较左节点，右节点
        return dfs(root.left,root.right);
    }

    boolean dfs(TreeNode left, TreeNode right) {
        //递归的终止条件是两个节点都为空
        //或者两个节点中有一个为空
        //或者两个节点的值不相等
        if(left==null && right==null) {
            return true;
        }
        if(left==null || right==null) {
            return false;
        }
        if(left.val!=right.val) {
            return false;
        }
        //再递归的比较 左节点的左孩子 和 右节点的右孩子
        //以及比较  左节点的右孩子 和 右节点的左孩子
        return dfs(left.left,right.right) && dfs(left.right,right.left);
    }
}
