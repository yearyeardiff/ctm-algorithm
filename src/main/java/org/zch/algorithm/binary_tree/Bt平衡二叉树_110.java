package org.zch.algorithm.binary_tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 */
public class Bt平衡二叉树_110 {
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

    /**
     * 对比左右子树高度，如果高度差<=1 计算最大高度
     * 如果高度差>1, 最大高度-1.通过是否等于-1来判断是否平衡
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    public int height (TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }


    /**
     *
     * 多返回值
     *
     * @param root
     * @return
     */
    public boolean isBalanced1(TreeNode root) {
        Map<Boolean, Integer> result = helper(root);
        return result.containsKey(Boolean.TRUE);
    }

    public Map<Boolean, Integer> helper(TreeNode root) {
        Map<Boolean, Integer> tmp =  new HashMap<>();
        if (root == null) {
            tmp.put(Boolean.TRUE, 0);
            return tmp;
        }

        Map<Boolean, Integer> left = helper(root.left);
        Map<Boolean, Integer> right = helper(root.right);

        if (left.containsKey(Boolean.FALSE) || right.containsKey(Boolean.FALSE)) {
            tmp.put(Boolean.FALSE, -1);
            return tmp;
        }

        if (left.get(Boolean.TRUE) - right.get(Boolean.TRUE) >= 0 && left.get(Boolean.TRUE) - right.get(Boolean.TRUE) <= 1) {
            tmp.put(Boolean.TRUE, left.get(Boolean.TRUE) + 1);
        } else if ((right.get(Boolean.TRUE) - left.get(Boolean.TRUE) >= 0 && right.get(Boolean.TRUE) - left.get(Boolean.TRUE) <= 1)) {
            tmp.put(Boolean.TRUE, right.get(Boolean.TRUE) + 1);
        } else {
            tmp.put(Boolean.FALSE, -1);
        }
        return tmp;
    }
}
