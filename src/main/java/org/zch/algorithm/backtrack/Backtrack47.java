package org.zch.algorithm.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * https://leetcode-cn.com/problems/permutations-ii/
 */
public class Backtrack47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> pathList = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, visited, new ArrayList<>(), pathList);
        return pathList;
    }

    private void backtrack(int[] nums, boolean[] visited, ArrayList<Integer> path, List<List<Integer>> pathList) {
        if (nums.length == path.size()) {
            pathList.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            // !visited[i - 1] i-1是表示深度相同的节点
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            System.out.println("递归前" + path);

            path.add(nums[i]);
            visited[i] = true;
            backtrack(nums, visited, path, pathList);

            path.remove(path.size() - 1);
            visited[i] = false;
            System.out.println("递归后" + path);

        }
    }

}
