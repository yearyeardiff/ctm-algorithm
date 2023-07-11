package org.zch.algorithm.binary_search.泛化;

public class 有界数组中指定下标处的最大值_1802 {
    public int maxValue(int n, int index, int maxSum) {
        int left = 1, right = maxSum;
        while (left < right) {
            // 此处+1，mid才会向右靠拢!!!!
            int mid = (left + right + 1) / 2;
            if (check(mid, n, index, maxSum)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean check(int mid, int n, int index, int maxSum) {
        long sum = cal(mid, index + 1) + cal(mid, n - index) - mid;
        return sum <= maxSum;
    }

    private long cal(int mid, int length) {
        if (mid >= length) {
            return(long) (mid - length + 1 + mid) * length / 2;
        }
        return (long) (1 + mid) * mid / 2 + (length - mid);
    }
}
