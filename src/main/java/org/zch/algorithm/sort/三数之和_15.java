package org.zch.algorithm.sort;

import java.util.*;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 三数之和_15 {
    List<List<Integer>> pathList = new ArrayList<>();

    /**
     * https://leetcode.cn/tag/sorting/problemset/
     * https://leetcode.cn/problems/contains-duplicate-iii/
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> pathList = new ArrayList<>();

        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] > 0) {
                    right --;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left ++;
                } else {
                    List<Integer> path = new ArrayList<>(3);
                    path.add(nums[i]);
                    path.add(nums[left]);
                    path.add(nums[right]);
                    pathList.add(path);
                    right --;
                    left ++;

                    while (left < right && nums[left] == nums[left-1])  left++;
                    while (left < right && nums[right] == nums[right+1])    right--;
                }
            }
        }
        return pathList;
    }







    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, 0, new ArrayList<>());
        return pathList;
    }

    private void backtrack(int[] nums, int idx, int sum, ArrayList<Integer> path) {
        if (path.size() == 3) {
            if (sum == 0) {
                pathList.add(new ArrayList<>(path));
            }
            return;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = idx; i < nums.length; i++) {
            if (set.add(nums[i])) {
                path.add(nums[i]);
                backtrack(nums, i + 1, sum + nums[i], path);
                path.remove(path.size() - 1);
            }
        }
    }


}
