package org.zch.algorithm.dp.子数组;

/**
 * @author zhangchenghao5
 */
public class 删除一次得到子数组的最大和_1186 {
    /**
     * https://leetcode.cn/problems/maximum-subarray-sum-with-one-deletion/solution/shan-chu-yi-ci-de-dao-zi-shu-zu-de-zui-d-o1o9/
     *
     * @param arr
     * @return
     */
    public int maximumSum(int[] arr) {
        int dp0 = arr[0], dp1 = 0, res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp1 = Math.max(dp0, dp1 + arr[i]);
            dp0 = Math.max(dp0, 0) + arr[i];
            res = Math.max(res, Math.max(dp0, dp1));
        }
        return res;
    }
}
