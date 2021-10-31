package org.zch.algorithm.backtrack.排列组合;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 *
 *https://leetcode-cn.com/problems/generate-parentheses/
 */
public class Backtrack括号生成的组合_22 {

    /**
     * 题解：
     * https://mp.weixin.qq.com/s/XVnoX-lBzColVvVXNkGc5g
     * https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {

        List<String> pathList = new ArrayList<>();
        backtrack(n, n, "",  pathList);
        return pathList;
    }

    private void backtrack(int left, int right, String path, List<String> pathList) {
        if (left > right) {
            return;
        }

        if (left == 0 && right == 0) {
            pathList.add(path);
            return;
        }

        if (left > 0) {
            backtrack(left - 1, right, path + "(", pathList);
        }

        if (right > 0) {
            backtrack(left, right - 1, path + ")", pathList);
        }
    }
}
