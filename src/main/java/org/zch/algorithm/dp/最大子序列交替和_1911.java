package org.zch.algorithm.dp;

import java.util.Deque;
import java.util.LinkedList;

public class 最大子序列交替和_1911 {


    public long maxAlternatingSum(int[] nums) {
        int length = nums.length;
        long[] dp = new long[2];
//        dp[0]表示持有股票  dp[1]表示不持有股票
//        可以理解为初始我们身上就有一张价值nums[0]的股票
//        dp[0]表示这张股票我们没有卖出去，还放在身上，所以资金为0
//        dp[1]表示这张股票卖了出去，所以我们身上有这张股票卖出去的钱
        dp[1] = nums[0];
        dp[0] = 0;
        for (int i = 1; i < length; i++) {
//            持有股票有两种可能，前一天也持有，也可能前一天不持有，二者取最大值
//            前一天不持有的话，今天持有，就需要付出今天股票的价格来购买今天的股票
            dp[0] = Math.max(dp[0], dp[1] - nums[i]);
//            同理
            dp[1] = Math.max(dp[1], dp[0] + nums[i]);
        }
//        最后一定是不持有股票，将股票卖出去后身上所剩下的钱最多
        return dp[1];
    }

    /**
     * 官方答案（与买卖股票类似）
     *
     * @param nums
     * @return
     */
    public long maxAlternatingSum1(int[] nums) {
        long even = nums[0], odd = 0;
        for (int i = 1; i < nums.length; i++) {
            even = Math.max(even, odd + nums[i]);
            odd = Math.max(odd, even - nums[i]);
        }
        return even;
    }


    /**
     * 单调栈
     *
     * @param nums
     * @return
     */
    public long maxAlternatingSum2(int[] nums) {
        long sum = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int min = stack.isEmpty() ? 0 : nums[stack.peek()];
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }

            stack.push(i);
            if (min < nums[i]) {
                sum = sum - min + nums[i];
            }
        }

        return sum;
    }
}
