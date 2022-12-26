package org.zch.algorithm.stack_queue.单调队列;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。如果不存在这样的 子数组 ，返回 -1 。
 *
 * 子数组 是数组中 连续 的一部分。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shortest-subarray-with-sum-at-least-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 和至少为K的最短子数组_862 {
    /**
     * https://leetcode.cn/problems/shortest-subarray-with-sum-at-least-k/solution/liang-zhang-tu-miao-dong-dan-diao-dui-li-9fvh/
     *
     * @param nums
     * @param k
     * @return
     */
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length, ans = n + 1;
        int[] sum = new int[n + 1];

        // 计算前缀和
        for (int i = 0; i < n; ++i)
            sum[i + 1] = sum[i] + nums[i];

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i <= n; ++i) {
            int curSum = sum[i];
            while (!queue.isEmpty() && curSum - sum[queue.peekFirst()] >= k)
                ans = Math.min(ans, i - queue.pollFirst()); // 优化一
            while (!queue.isEmpty() && sum[queue.peekLast()] >= curSum) // 单调递增队列
                queue.pollLast(); // 优化二
            queue.addLast(i);
        }
        return ans > n ? -1 : ans;
    }
}
