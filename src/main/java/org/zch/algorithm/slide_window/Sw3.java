package org.zch.algorithm.slide_window;

import java.util.HashMap;
import java.util.Map;

/**
 *给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 */
public class Sw3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> winMap = new HashMap<>();

        int left = 0, right = 0, maxLen = 0;
        while (right < s.length()) {
            char cur = s.charAt(right);
            winMap.put(cur, winMap.getOrDefault(cur, 0) + 1);
            right ++;

            while (winMap.getOrDefault(cur, 0) > 1) {
                char tmp = s.charAt(left);
                winMap.put(tmp, winMap.get(tmp) - 1);
                left ++;
            }
            if (right - left > maxLen) {
                maxLen = right -left;
            }
        }
        return maxLen;
    }
}
