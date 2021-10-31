package org.zch.algorithm.binary_tree.构建二叉树;

/**
 * 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class Bt从前序与中序遍历序列构造二叉树105 {

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
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

    }

    public TreeNode build(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int root = preOrder[preStart];
        int rootIdx = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == root) {
                rootIdx = i;
                break;
            }
        }
        int leftSize = rootIdx - inStart;

        TreeNode node = new TreeNode(root);
        node.left = build(preOrder, preStart + 1, preStart + leftSize, inOrder, inStart, rootIdx - 1);
        node.right = build(preOrder, preStart + leftSize + 1, preEnd, inOrder, rootIdx + 1, inEnd);

        return node;

    }
}
