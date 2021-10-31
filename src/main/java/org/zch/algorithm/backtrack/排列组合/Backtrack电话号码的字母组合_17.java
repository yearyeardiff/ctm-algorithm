package org.zch.algorithm.backtrack.排列组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Backtrack电话号码的字母组合_17 {
    private final static Map<Character, String> map = new HashMap<>();

    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> pathList = new ArrayList<>();

        backtrack(digits, 0, new ArrayList<>(), pathList);

        return pathList;
    }

    public void backtrack(String digits, int pos, List<Character> path, List<String> pathList) {
        if (pos >= digits.length()) {
            if (path.size() == 0) {
                return;
            }
            pathList.add(path.stream().map(String::valueOf).collect(Collectors.joining()));
            return;
        }

        String str = map.get(digits.charAt(pos));
        if (str == null) {
            backtrack(digits, pos + 1, path, pathList);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            path.add(str.charAt(i));
            backtrack(digits, pos + 1, path, pathList);
            path.remove(path.size() - 1);
        }
    }
}
