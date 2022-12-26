package org.zch.algorithm.disjoin_set;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 最长连续序列_128 {

    /**
     * 并查集：https://leetcode.cn/problems/longest-consecutive-sequence/solution/by-lfool-jdy4/
     * hash表统计：https://leetcode.cn/problems/longest-consecutive-sequence/solution/ha-xi-zui-qing-xi-yi-dong-de-jiang-jie-c-xpnr/
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLen = 0;
        for (Integer num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            int tmp = num;
            while (set.contains(tmp + 1)) {
                tmp = tmp + 1;
            }
            maxLen = Math.max(tmp - num + 1, maxLen);
        }

        return maxLen;
    }
}
