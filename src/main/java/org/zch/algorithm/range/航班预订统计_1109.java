package org.zch.algorithm.range;

/**
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 *
 * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
 *
 * 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/corporate-flight-bookings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 航班预订统计_1109 {
    /**
     * 差分数组
     *
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];

        for (int i = 0; i < bookings.length; i++) {
            int l = bookings[i][0] - 1, r = bookings[i][1] - 1, v = bookings[i][2];

            diff[l] += v;
            if (r + 1 < n) {
                diff[r + 1] -= v;
            }
        }

        int[] result = new int[n];
        result[0] = diff[0];

        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] + diff[i];
        }
        return result;
    }


}
