package org.zch.algorithm.sort;

import java.time.LocalDate;
import java.util.*;

/**
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 *
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 */
public class 丑数_264 {

    /**
     * https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247490029&idx=1&sn=bba9ddff88d247db310406ee418d5a15
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] nums = new int[] {2, 3, 5};
        Queue<Long> pq = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();

        pq.offer(1L);
        set.add(1L);

        while (!pq.isEmpty()) {
            long min = pq.poll();
            if (n == 1) {
                return (int) min;
            }
            n--;
            for (int num : nums) {
                if (set.add(num * min)) {
                    pq.offer(min * num);
                }
            }
        }

        return -1;
    }

    public int nearestValidPoint(int x, int y, int[][] points) {
        int minIdx = points.length;
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];

            if (point[0] == x) {
                int currentDistance = Math.abs(point[1] - y);
                if (distance > currentDistance) {
                    distance = currentDistance;
                    minIdx = i;
                }
            } else if (point[1] == y) {
                int currentDistance = Math.abs(point[0] - x);
                if (distance > currentDistance) {
                    distance = currentDistance;
                    minIdx = i;
                }
            }
        }
        return minIdx == points.length ? -1 : minIdx;
    }

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.minusDays(localDate.getDayOfWeek().getValue()).minusDays(0 * 7 - 1));
    }
}
