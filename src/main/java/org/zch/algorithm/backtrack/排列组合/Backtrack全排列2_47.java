package org.zch.algorithm.backtrack.排列组合;

import java.util.*;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * https://leetcode-cn.com/problems/permutations-ii/
 */
public class Backtrack全排列2_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> pathList = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, visited, new ArrayList<>(), pathList);
        return pathList;
    }

    /**
     * 去重方式：
     * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/solution/gong-shui-san-xie-tong-yong-shi-xian-qu-4jbkj/
     * 1. set去重
     * 2. 排序去重
     *
     * @param nums
     * @param visited
     * @param path
     * @param pathList
     */
    private void backtrack(int[] nums, boolean[] visited, ArrayList<Integer> path, List<List<Integer>> pathList) {
        if (nums.length == path.size()) {
            pathList.add(new ArrayList<>(path));
            return;
        }

        Set<Integer> child = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (!child.add(nums[i])) {
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
