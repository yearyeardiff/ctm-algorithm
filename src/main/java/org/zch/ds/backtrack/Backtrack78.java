package org.zch.ds.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * https://leetcode-cn.com/problems/subsets/
 */
public class Backtrack78 {
    /**
     * 回溯法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(nums, 0, subset, rst);
        return rst;
    }

    private void backtrack(int[] nums, int index, List<Integer> subset, List<List<Integer>> rst) {
        rst.add(new ArrayList<>(subset));
        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(nums, i + 1, subset, rst);
            subset.remove(subset.size() - 1);
        }
    }


    /**
     * 前序遍历
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets1(int[] nums) {
        ArrayList<Integer> subset = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        preOrder(nums, 0, subset, res);
        return res;
    }

    public static void preOrder(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        preOrder(nums, i + 1, subset, res);
        subset.remove(subset.size() - 1);
        preOrder(nums, i + 1, subset, res);
    }


}
