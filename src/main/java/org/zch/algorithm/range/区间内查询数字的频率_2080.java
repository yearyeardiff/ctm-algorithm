package org.zch.algorithm.range;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请你设计一个数据结构，它能求出给定子数组内一个给定值的 频率 。
 * <p>
 * 子数组中一个值的 频率 指的是这个子数组中这个值的出现次数。
 * <p>
 * 请你实现 RangeFreqQuery 类：
 * <p>
 * RangeFreqQuery(int[] arr) 用下标从 0 开始的整数数组 arr 构造一个类的实例。
 * int query(int left, int right, int value) 返回子数组 arr[left...right] 中 value 的 频率 。
 * 一个 子数组 指的是数组中一段连续的元素。arr[left...right] 指的是 nums 中包含下标 left 和 right 在内 的中间一段连续元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/range-frequency-queries
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 区间内查询数字的频率_2080 {
    // 数组数组解法：https://leetcode.cn/problems/range-frequency-queries/solution/c-shu-zhuang-shu-zu-jie-fa-by-chengziqia-5jw2/
    // hash+二分法：https://leetcode.cn/problems/range-frequency-queries/solution/qu-jian-nei-cha-xun-shu-zi-de-pin-lu-by-wh4ez/

    Map<Integer, List<Integer>> map = new HashMap<>();

    public 区间内查询数字的频率_2080(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i], list);
        }
    }

    public int query(int left, int right, int value) {
        if (!map.containsKey(value)) return 0;
        List<Integer> list = map.get(value);
        int l = getLeftIndex(list, left);
        if (l == -1) return 0;
        int r = getRightIndex(list, right);
        return r - l + 1;
    }

    private int getLeftIndex(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (list.get(mid) >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private int getRightIndex(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (list.get(mid) <= target) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}
