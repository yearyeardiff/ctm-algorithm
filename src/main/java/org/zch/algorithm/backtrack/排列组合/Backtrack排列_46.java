package org.zch.algorithm.backtrack.排列组合;

import java.util.ArrayList;
import java.util.List;

/**
 *给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * https://leetcode-cn.com/problems/permutations/
 *
 */
public class Backtrack排列_46 {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> pathList = new ArrayList<>();

        backtrack(nums, visited, new ArrayList<>(), pathList);
        return pathList;
    }

    public void backtrack(int[] nums, boolean[] visited, List<Integer> path, List<List<Integer>> pathList) {
        if (path.size() == nums.length) {
            pathList.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            path.add(nums[i]);
            visited[i] = true;
            backtrack(nums, visited, path, pathList);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }


}
