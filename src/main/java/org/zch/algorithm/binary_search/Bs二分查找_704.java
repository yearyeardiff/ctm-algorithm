package org.zch.algorithm.binary_search;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Bs二分查找_704 {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;

    }

    /**
     * 另外的题解：https://leetcode-cn.com/problems/binary-search/solution/leetcode-offer-er-fen-cha-zhao-san-da-mo-0mn7/
     *
     * @param nums
     * @param target
     * @return
     */
    public int search_left_bound(int[] nums, int target) {

        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) >> 1;

            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                right = mid;
            }
        }
        if (left >= nums.length) {
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

    public int search_right_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) >> 1;

            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (left == 0) {
            return  -1;
        }
        return nums[left - 1] == target ? left -1 : -1;

    }
}
