package org.zch.algorithm.range.前缀和;

public class 除自身以外数组的乘积_238 {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        int[] leftArr = new int[nums.length + 1], rightArr = new int[nums.length + 1];
        leftArr[0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            leftArr[i] = leftArr[i - 1] * nums[i - 1];
        }

        rightArr[nums.length] = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            rightArr[i] = rightArr[i + 1] * nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            res[i] = leftArr[i] * rightArr[i + 1];
        }

        return res;
    }
}
