package org.zch.algorithm.常用算法;

public class 多数元素_169 {
    /**
     *
     * https://leetcode.cn/problems/majority-element/solutions/2362000/169-duo-shu-yuan-su-mo-er-tou-piao-qing-ledrh/
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int candidate = nums[0], cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (cnt == 0) {
                candidate = nums[i];
            }
            cnt += candidate == nums[i] ? 1 : -1;
        }

        return candidate;
    }
}
