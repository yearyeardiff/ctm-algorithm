package org.zch.algorithm.binary_tree.路径问题;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * https://leetcode-cn.com/problems/binary-tree-paths/
 */
public class Bt二叉树的所有路径_257 {
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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        binaryTreePaths(root, paths,  "");
        return paths;
    }

    public void binaryTreePaths(TreeNode root, List<String> paths, String path) {
        if (root == null) {
            return;
        }
        path += root.val;
        if (root.left == null && root.right == null) {
            paths.add(path);
        }
        binaryTreePaths(root.left, paths, path + "->");
        binaryTreePaths(root.right, paths, path + "->");
    }
}
