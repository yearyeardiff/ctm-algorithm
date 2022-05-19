package org.zch.algorithm.binary_tree.构建二叉树;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class Bt从中序与后序遍历序列构造二叉树_106 {
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }

        int rootVal = postOrder[postEnd];
        int rootIdx = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == rootVal) {
                rootIdx = i;
                break;
            }
        }
        int leftSize = rootIdx - inStart;

        TreeNode node = new TreeNode(rootVal);
        node.left = build(inOrder, inStart, rootIdx - 1, postOrder, postStart, postStart + leftSize - 1);
        node.right = build(inOrder, rootIdx + 1, inEnd, postOrder, postStart + leftSize, postEnd - 1);

        return node;
    }
}
