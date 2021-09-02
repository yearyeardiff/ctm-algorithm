package org.zch.ds.binary_tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Bt98 {
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
     * 中序遍历（堆栈）
     *
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {

        TreeNode cur = root;
        Integer preVal = null;
        Deque<TreeNode> stack = new LinkedList<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode tmp = stack.pop();
            if (preVal != null && preVal >= tmp.val) {
                return false;
            }
            preVal = tmp.val;
            cur = tmp.right;
        }
        return true;
    }

    Integer preVal = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }

        if (preVal != null && preVal >= root.val) {
            return false;
        }
        preVal = root.val;

        return isValidBST(root.right);
    }



}
