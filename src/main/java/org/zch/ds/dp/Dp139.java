package org.zch.ds.dp;

import java.util.List;

/**
 *给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Dp139 {
    /**
     * https://leetcode-cn.com/problems/word-break/solution/dai-ma-sui-xiang-lu-139-dan-ci-chai-fen-50a1a/
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak0(String s, List<String> wordDict) {
        boolean[] valid = new boolean[s.length() + 1];
        valid[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (valid[j] && wordDict.contains(s.substring(j, i))) {
                    valid[i] = true;
                    break;
                }
            }
        }

        return valid[s.length()];
    }

    /**
     * https://leetcode-cn.com/problems/word-break/solution/shou-hui-tu-jie-san-chong-fang-fa-dfs-bfs-dong-tai/
     *
     * @param s
     * @param wordDict
     * @return
     */
    //-------------------------------------------------------------------------------------------------------------------------------------
    public boolean wordBreak1(String s, List<String> wordDict) {
        return backtrack(s, wordDict, 0);
    }

    public boolean backtrack(String s, List<String> wordDict, int pos) {
        if (pos == s.length()) {//指针越界，s一步步成功划分为单词，才走到越界这步，现在没有剩余子串
            return true;   //返回真，结束递归
        }
        for (int i = pos + 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(pos, i)) && backtrack(s, wordDict, i)) {
                return true;
            }
        }
        return false;
    }
}
