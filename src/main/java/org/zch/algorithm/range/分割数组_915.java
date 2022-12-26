package org.zch.algorithm.range;

/**
 * 给定一个数组 nums ，将其划分为两个连续子数组 left 和 right， 使得：
 *
 * left 中的每个元素都小于或等于 right 中的每个元素。
 * left 和 right 都是非空的。
 * left 的长度要尽可能小。
 * 在完成这样的分组后返回 left 的 长度 。
 *
 * 用例可以保证存在这样的划分方法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/partition-array-into-disjoint-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 分割数组_915 {
    public int partitionDisjoint(int[] nums) {
        int[] leftMax = new int[nums.length];
        int[] rightMin = new int[nums.length];

        leftMax[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
        }

        rightMin[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            rightMin[i] = Math.min(nums[i], rightMin[i + 1]);
        }

        for (int i = 0; i < leftMax.length; i++) {
            if (leftMax[i] <= rightMin[i + 1]) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        分割数组_915 test = new 分割数组_915();
        test.partitionDisjoint(new int[]{32,57,24,19,0,24,49,67,87,87});
    }
}
