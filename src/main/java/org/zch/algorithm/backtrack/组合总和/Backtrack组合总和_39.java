package org.zch.algorithm.backtrack.组合总和;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 *
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。 
 *
 * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Backtrack组合总和_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> pathList = new ArrayList<>();
        backtrack(candidates, 0, 0, target, new ArrayList<>(), pathList);
        return pathList;
    }

    public void backtrack(int[] candidates, int start, int sum, int target, List<Integer> path, List<List<Integer>> pathList) {
        if (sum == target) {
            pathList.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                continue;
            }
            path.add(candidates[i]);
            backtrack(candidates, i, sum + candidates[i], target, path, pathList);
            path.remove(path.size() - 1);
        }
    }
}
