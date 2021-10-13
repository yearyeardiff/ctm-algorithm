package org.zch.ds.dp;

/**
 * 分割等和子集
 *
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 */
public class Dp416 {

    /**
     * https://leetcode-cn.com/problems/partition-equal-subset-sum/solution/gong-shui-san-xie-bei-bao-wen-ti-shang-r-ln14/
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        //「等和子集」的和必然是总和的一半
        int sum = 0;
        for (int i : nums) sum += i;

        if (sum % 2 == 1) {
            return false;
        }

        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][target + 1];

        dp[0][0] = true;
        for (int i = 1; i <= nums.length; i++) {
            dp[i][0] = false;
        }

        for (int j = 1; j <= target; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                boolean select = j >= nums[i - 1] && dp[i - 1][j - nums[i - 1]];
                boolean unSelect = dp[i - 1][j];
                dp[i][j] = select || unSelect;
            }
        }

        return dp[nums.length][target];

    }


    /**
     * 一维数组
     *
     * @param nums
     * @return
     */
    public boolean canPartition2(int[] nums) {
        int n = nums.length;

        //「等和子集」的和必然是总和的一半
        int sum = 0;
        for (int i : nums) sum += i;

        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 1; i <= target; i++) {
            dp[i] = false;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= 0; j--) {
                boolean unSelect = dp[j];
                boolean select = j >= nums[i] && dp[j - nums[i]];
                dp[j] = unSelect || select;
            }
        }

        return dp[target];
    }
}
