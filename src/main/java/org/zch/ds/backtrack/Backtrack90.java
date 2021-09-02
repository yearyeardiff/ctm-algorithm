package org.zch.ds.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 *  
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Backtrack90 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(nums, 0, subset, result);
        return result;
    }

    private static void backtrack(int[] nums, int index, List<Integer> subset, List<List<Integer>> result) {
        result.add(new ArrayList<>(subset));

        Set<Integer> child = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            // 剪枝
            if (!child.add(nums[i])) {
                continue;
            }
            // 做出选择
            subset.add(nums[i]);
            //递归进入下一层，注意i+1，标识下一个选择列表的开始位置，最重要的一步
            backtrack(nums, i + 1, subset, result);
            // 回溯
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1,2,2}));
    }
}
