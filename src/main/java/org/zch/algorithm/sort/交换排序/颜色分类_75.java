package org.zch.algorithm.sort.交换排序;


/**
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 颜色分类_75 {
    /**
     * 经典的荷兰国旗问题，由于题目本质是要我们将数分成三段。
     * https://leetcode.cn/problems/sort-colors/solution/by-ac_oier-7lwk/
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int len = nums.length;
        int l = 0, r = len - 1, idx = 0;

        while (idx <= r) {
            if (nums[idx] == 0) {
                swap(nums, idx++, l++);
            } else if (nums[idx] == 2) {
                swap(nums, idx, r--);
            } else {
                idx++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
