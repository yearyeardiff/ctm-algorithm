package org.zch.algorithm.binary_tree.树的遍历;



import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 后序遍历
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * 题解：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/tu-jie-er-cha-shu-de-si-chong-bian-li-by-z1m/
 */
public class PostTraversal {

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

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }

        List<Integer> result = new ArrayList<>();

        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        TreeNode cur = root;
        TreeNode pre = null;
        Deque<TreeNode> stack = new LinkedList<>();

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode tmp = stack.peek();
            if (tmp.right == null || tmp.right == pre) {
                result.add(tmp.val);
                stack.pop();
                pre = tmp;
                cur = null;
            } else {
                cur = tmp.right;
            }
        }

        return result;
    }



}
