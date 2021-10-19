package org.zch.algorithm.slide_window;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *
 * https://leetcode-cn.com/problems/permutation-in-string/
 */
public class Sw576 {

    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];
        }
        int left = 0;
        for (int right = 0; right < m; ++right) {
            int x = s2.charAt(right) - 'a';
            ++cnt[x];
            while (cnt[x] > 0) {
                --cnt[s2.charAt(left) - 'a'];
                ++left;
            }
            if (right - left + 1 == n) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkInclusion1(String s1, String s2) {

        Map<Character, Integer> needMap = new HashMap<>();
        Map<Character, Integer> windMap = new HashMap<>();

        for (Character c : s1.toCharArray()) {
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;

        while (right < s2.length()) {
            char cur = s2.charAt(right);
            windMap.put(cur, windMap.getOrDefault(cur, 0) + 1);
            right ++;

            while (windMap.getOrDefault(cur, 0) > needMap.getOrDefault(cur, 0)) {
                char tmp = s2.charAt(left);
                windMap.put(tmp, windMap.get(tmp) -1);
                left ++;
            }

            if (right - left == s1.length()) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        checkInclusion1("ab", "eidboaoo");
    }

}
