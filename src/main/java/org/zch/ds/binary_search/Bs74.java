package org.zch.ds.binary_search;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Bs74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        int left = 0, right = m * n -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = matrix[mid / n][mid % n];
            if (target > midVal) {
                left = mid + 1;
            } else if (target < midVal) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;

    }
}
