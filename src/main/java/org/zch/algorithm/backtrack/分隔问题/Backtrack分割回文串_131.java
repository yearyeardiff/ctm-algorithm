package org.zch.algorithm.backtrack.分隔问题;

import java.util.ArrayList;
import java.util.List;

/**
 *给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 *
 *https://leetcode-cn.com/problems/palindrome-partitioning/
 *
 */
public class Backtrack分割回文串_131 {

    /**
     * https://leetcode-cn.com/problems/palindrome-partitioning/solution/dfs-hui-su-by-synhard-5zp1/
     *
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(String s, int index, List<String> path, List<List<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index + 1; i <= s.length(); i++) {
            String temp = s.substring(index, i);
            if (check(temp)) {
                path.add(temp);
                dfs(s, i, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean check(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
                continue;
            }
            return false;
        }
        return true;
    }
}
