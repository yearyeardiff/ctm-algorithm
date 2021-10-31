package org.zch.algorithm.binary_tree.BST;

/**
 *给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 *
 *https://leetcode-cn.com/problems/unique-binary-search-trees/
 */
public class Bt不同二叉搜索树_96 {

    // 备忘录
    int[][] memo;

    /**
     * https://mp.weixin.qq.com/s/kcwz2lyRxxOsC3n11qdVSw
     *
     * @param n
     * @return
     */
    int numTrees(int n) {
        // 备忘录的值初始化为 0
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }

    int count(int lo, int hi) {
        if (lo > hi) return 1;
        // 查备忘录
        if (memo[lo][hi] != 0) {
            return memo[lo][hi];
        }

        int res = 0;
        for (int mid = lo; mid <= hi; mid++) {
            int left = count(lo, mid - 1);
            int right = count(mid + 1, hi);
            res += left * right;
        }
        // 将结果存入备忘录
        memo[lo][hi] = res;

        return res;
    }

}
