package org.zch.algorithm.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *输入一个字符串，打印出该字符串中字符的所有排列。
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 *https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 */
public class Backtrack38 {
    public static String[] permutation(String s) {
        List<String> pathList = new ArrayList<>();
        boolean[] visited = new boolean[s.length()];
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        backtrack(chars, visited, "", pathList);
        return pathList.toArray(new String[0]);
    }

    public static void backtrack(char[] chars, boolean[] visited, String path, List<String> pathList) {
        if (chars.length == path.length()) {
            pathList.add(path);
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) {
                continue;
            }

            if (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1]) {
                continue;
            }

            path += chars[i];
            visited[i] = true;
            System.out.println("递归前：" + path);
            backtrack(chars, visited, path, pathList);

            path = path.substring(0, path.length() - 1);
            visited[i] = false;
            System.out.println("递归后：" + path);
        }
    }

    public static void main(String[] args) {
        System.out.println(permutation("aab"));
    }
}
