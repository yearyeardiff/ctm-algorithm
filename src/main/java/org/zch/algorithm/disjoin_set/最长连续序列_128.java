package org.zch.algorithm.disjoin_set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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


    /**
     * 并查集
     *
     * @param nums
     * @return
     */
    public int longestConsecutive2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        Uf uf = new Uf(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i] + 1) || map.get(nums[i]) != i) {
                continue;
            }
            uf.union(i, map.get(nums[i] + 1));
        }

        return uf.getMaxSize();
    }

    public class Uf {
        private int[] parent;
        private int[] size;
        public Uf(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }


        public void union(int p, Integer q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (size[rootP] < size[rootQ]) {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            } else {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }

        }

        private int find(int p) {
            while (parent[p] != p) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public int getMaxSize() {
            int max = 0;
            for (int s :  size) {
                max = Math.max(s, max);
            }
            return max;
        }
    }
}
