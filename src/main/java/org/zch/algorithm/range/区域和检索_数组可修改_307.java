package org.zch.algorithm.range;

/**
 * 给你一个数组 nums ，请你完成两类查询。
 *
 * 其中一类查询要求 更新 数组 nums 下标对应的值
 * 另一类查询要求返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 ，其中 left <= right
 * 实现 NumArray 类：
 *
 * NumArray(int[] nums) 用整数数组 nums 初始化对象
 * void update(int index, int val) 将 nums[index] 的值 更新 为 val
 * int sumRange(int left, int right) 返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 （即，nums[left] + nums[left + 1], ..., nums[right]）
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/range-sum-query-mutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 区域和检索_数组可修改_307 {
    /**
     * 树状数组
     * https://leetcode.cn/problems/range-sum-query-mutable/solution/guan-yu-ge-lei-qu-jian-he-wen-ti-ru-he-x-41hv/
     * https://blog.csdn.net/ls2868916989/article/details/119268741
     */
    class NumArray {

        public NumArray(int[] nums) {

        }

        public void update(int index, int val) {

        }

        public int sumRange(int left, int right) {
            return 0;
        }
    }

    public static void main(String[] args) {
        printBinary(6);
        printBinary(-6);
    }

    public static void printBinary(int a){
        for (int i = 31; i >= 0; i--){
            System.out.print((a >> i) & 1);
        }
        System.out.println();
    }
}
