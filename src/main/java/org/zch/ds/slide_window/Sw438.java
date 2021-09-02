package org.zch.ds.slide_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指字母相同，但排列不同的字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sw438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indexList = new ArrayList<>();
        Map<Character, Integer> needMap = new HashMap<>();
        Map<Character, Integer> windMap = new HashMap<>();

        for (Character c : p.toCharArray()) {
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        while (right < s.length()) {
            char cur = s.charAt(right);
            windMap.put(cur, windMap.getOrDefault(cur, 0) + 1);
            right ++;

            while (windMap.getOrDefault(cur, 0) > needMap.getOrDefault(cur, 0)) {
                char tmp = s.charAt(left);
                windMap.put(tmp, windMap.get(tmp) -1);
                left ++;
            }

            if (right - left == p.length()) {
                indexList.add(left);
            }
        }
        return indexList;
    }


}
