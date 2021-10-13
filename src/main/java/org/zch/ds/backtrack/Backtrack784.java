package org.zch.ds.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 *
 * https://leetcode-cn.com/problems/letter-case-permutation/
 *
 */
public class Backtrack784 {

    static List<String> res = new ArrayList<>();
    /**
     * 回溯法
     *
     * @param s
     * @return
     */
    public static List<String> letterCasePermutation2(String S) {
        //(1)添加空集
        res.add(S);
        //(2)回溯
        backTrack(S.toCharArray(), 0);
        return res;
    }

    private static void backTrack(char[] SArr, int start) {
        //(1)遍历【决策树】每层
        for (int i = start; i < SArr.length; i++) {
            //(2)遍历【选择列表】
            //(2.1)判断是否为字母，根据题说明，不是数字即为字母，而字母大小写的ASCII码都比数字大
            if (SArr[i] > '9') {
                //大小写转换通过异或转换大小写
                SArr[i] ^= (1 << 5);
                //(2)记录子集
                res.add(String.valueOf(SArr));
                //剪枝条件：决策树子节点<父节点
                //实现剪枝：传递i+1作为start
                backTrack(SArr, i + 1);
                SArr[i] ^= (1 << 5);
            }
        }
    }


    /**
     * 前序遍历树
     *
     * @param s
     * @return
     */
    public static List<String> letterCasePermutation(String s) {
        List<String> pathList = new ArrayList<>();
        preOrder(s, 0, "", pathList);
        return pathList;
    }


    public static void preOrder(String s, int pos, String path, List<String> pathList) {
        if (path.length() == s.length()) {
            pathList.add(path);
            return;
        }

        char current = s.charAt(pos);
        path += current;
        preOrder(s, pos + 1, path, pathList);
        if (current >= '0' && current <= '9') {
        } else {
            path = path.substring(0, path.length() - 1);
            path += (char) (current ^ (1 << 5));
            preOrder(s, pos + 1, path, pathList);
        }
    }

    public static void preOrder2(String s, int pos, List<Character> path, List<List<Character>> pathList) {
        if (path.size() == s.length()) {
            pathList.add(path);
            return;
        }

        char current = s.charAt(pos);
        path.add(current);
        preOrder2(s, pos + 1, new ArrayList<>(path), pathList);
        if (current >= '0' && current <= '9') {
        } else {
            path.remove(path.size() - 1);
            path.add((char)(current - 'a' + 'A'));
            preOrder2(s, pos + 1, new ArrayList<>(path), pathList);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCasePermutation2("a1b2"));
    }

}
