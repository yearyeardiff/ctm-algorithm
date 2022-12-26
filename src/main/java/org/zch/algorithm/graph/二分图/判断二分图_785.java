package org.zch.algorithm.graph.二分图;

import java.util.stream.Stream;

/**
 * https://mp.weixin.qq.com/s/5tMzyADbfIJAAvRfSy41Ng
 */
public class 判断二分图_785 {
    public static int minElements(int[] nums, int limit, int goal) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        int diff = Math.abs(goal - sum);
        return diff % limit == 0 ? diff / limit : diff / limit + 1;
    }

    public static void main(String[] args) {
        minElements(new int[]{1, -1, 1}, 3, -4);
    }

}
