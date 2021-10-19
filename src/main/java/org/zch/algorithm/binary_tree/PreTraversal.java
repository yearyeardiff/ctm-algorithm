package org.zch.algorithm.binary_tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * 题解：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/tu-jie-er-cha-shu-de-si-chong-bian-li-by-z1m/
 */
public class PreTraversal {

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
     *
     * 前序遍历 递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }

        List result = new ArrayList();
        result.add(root.val);
        result.addAll(preorderTraversal1(root.left));
        result.addAll(preorderTraversal1(root.right));
        return result;
    }

    /**
     * 前序遍历(模板解法)
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> valList = new ArrayList<>();
        TreeNode p = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                valList.add(p.val);
                p = p.left;
            }

            TreeNode tmp = stack.pop();
            p = tmp.right;
        }
        return valList;
    }

    /**
     * 前序遍历(常规解法)
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal3(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }

        List<Integer> valList = new ArrayList<>();
        TreeNode p = root;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(p);
        while (!stack.isEmpty()) {
            p = stack.pop();
            valList.add(p.val);
            if (p.right != null) {
                stack.push(p.right);
            }
            if (p.left != null) {
                stack.push(p.left);
            }
        }
        return valList;
    }
}
