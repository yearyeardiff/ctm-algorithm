package org.zch.ds.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 *
 * https://leetcode-cn.com/problems/combinations/
 */
public class Backtrack77 {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> pathList = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>(), pathList);
        return pathList;
    }

    public static void backtrack(int n, int k, int start, List<Integer> path, List<List<Integer>> pathList) {
        if (path.size() == k) {
            pathList.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {
            path.add(i);
            backtrack(n, k, i + 1, path, pathList);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }
}
