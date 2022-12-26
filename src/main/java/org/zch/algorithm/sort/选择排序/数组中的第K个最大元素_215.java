package org.zch.algorithm.sort.选择排序;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 数组中的第K个最大元素_215 {
    /**
     * 堆排序 最大堆
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        buildHeap(nums);

        int length = nums.length;
        for (int i = 0; i < k - 1; i++) {
            nums[0] = nums[length - 1 - i];
            adjust(0, nums, nums.length - i - 1);
        }
        return nums[0];
    }

    public void buildHeap(int[] nums) {
        for (int i = nums.length / 2; i >= 0; i --) {
            this.adjust(i, nums, nums.length);
        }
    }

    private void adjust(int idx, int[] nums, int length) {
        int parent = idx;
        while (parent * 2 + 1 < length) {
            int child = parent * 2 + 1;
            if (child + 1 < length && nums[child] < nums[child + 1]) {
                child = child + 1;
            }

            if (nums[child] <= nums[parent]) {
                break;
            }

            // swap
            int temp = nums[parent];
            nums[parent] = nums[child];
            nums[child] = temp;

            parent = child;
        }
    }
}
