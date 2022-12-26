package org.zch.algorithm.binary_search.泛化;

import java.util.Arrays;

public class 两球之间的磁力_1552 {
    /**
     * 转换问题：当最小磁力为t时，能否存放m个球,求最大的t
     *
     * @param position
     * @param m
     * @return
     */
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1, right = position[position.length - 1] - position[0], ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid, position, m)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    /**
     * 当最小磁力为x时，能否存放m个球
     *
     * @param x
     * @param position
     * @param m
     * @return
     */
    public boolean check(int x, int[] position, int m) {
        int pre = position[0], cnt = 1;
        for (int i = 1; i < position.length; ++i) {
            if (position[i] - pre >= x) {
                pre = position[i];
                cnt += 1;
            }
        }
        return cnt >= m;
    }
}
