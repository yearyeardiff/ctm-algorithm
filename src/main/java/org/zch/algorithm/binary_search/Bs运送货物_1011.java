package org.zch.algorithm.binary_search;

/**
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 *
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 *
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Bs运送货物_1011 {
    /**
     * https://mp.weixin.qq.com/s/JgJ0jh2SJd6grQSPnN6Jww
     *
     * @param weights
     * @param days
     * @return
     */
    public static int shipWithinDays(int[] weights, int days) {
        int low = 1, high = weights.length -1;
        for (int w : weights) {
            low = Math.max(low, w);
            high += w;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (f(weights, mid) < days) {
                high = mid - 1;
            } else if (f(weights, mid) > days) {
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        return low;
    }

    static int f(int[] weights, int x) {
        int day = 1;
        int sum = 0;
        for (int weight : weights) {
            if (sum + weight <= x) {
                sum += weight;
            } else {
                sum = weight;
                day ++;
            }
        }
        System.out.println(x + ":" + day);
        return day;
    }

    public static void main(String[] args) {
        shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5);
    }
}
