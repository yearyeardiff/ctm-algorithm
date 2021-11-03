package org.zch.algorithm.slide_window;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 *  
 *
 * 注意：
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Sw最小覆盖子串_76 {
    static Map<Character, Integer> needMap = new HashMap<>();
    static Map<Character, Integer> cntMap = new HashMap<>();

    public static String minWindow(String s, String t) {

        for (Character c : t.toCharArray()) {
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int retPos = -1, retLength = Integer.MAX_VALUE;
        while (right < s.length()) {
            char curChar = s.charAt(right);
            if (needMap.containsKey(curChar)) {
                cntMap.put(curChar, cntMap.getOrDefault(curChar, 0) + 1);
            }

            right ++;

            while (check() && left <= right) {

                if (right - left < retLength) {
                    retPos = left;
                    retLength = right - left;
                }

                char tmp = s.charAt(left);
                if (needMap.containsKey(tmp)) {
                    cntMap.put(tmp, cntMap.getOrDefault(tmp, 0) - 1);
                }
                left ++;
            }
        }

        if (retPos < 0) {
            return "";
        }
        return s.substring(retPos, retPos + retLength);

    }

    private static boolean check() {
        for (Map.Entry<Character, Integer> entry : needMap.entrySet()) {
            if (cntMap.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("a", "a"));
    }
}
