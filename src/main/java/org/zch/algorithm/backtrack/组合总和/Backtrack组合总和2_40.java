package org.zch.algorithm.backtrack.组合总和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 注意：解集不能包含重复的组合。 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Backtrack组合总和2_40 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> pathList = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, 0, new ArrayList<>(), pathList);
        return pathList;
    }

    /**
     * 去重方式：
     * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/solution/gong-shui-san-xie-tong-yong-shi-xian-qu-4jbkj/
     * 1. set去重
     * 2. 排序去重
     *
     * @param candidates
     * @param target
     * @param sum
     * @param start
     * @param path
     * @param pathList
     */
    public static void backtrack(int[] candidates, int target, int sum, int start, List<Integer> path, List<List<Integer>> pathList) {
        if (sum == target) {
            pathList.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                continue;
            }
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            backtrack(candidates, target, sum + candidates[i], i + 1 , path, pathList);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5},8));
    }
}
