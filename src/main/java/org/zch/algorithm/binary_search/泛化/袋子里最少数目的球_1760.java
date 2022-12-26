package org.zch.algorithm.binary_search.泛化;

import java.util.Arrays;

public class 袋子里最少数目的球_1760 {
    /**
     * 遇到，最大最小之类的描述，就是经典二分了。这里给出1道相似的例题：
     *
     * 1552. 两球之间的磁力
     *
     * @param nums
     * @param maxOperations
     * @return
     */
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = Arrays.stream(nums).max().getAsInt();
        while (left < right) {
            int mid = left + (right - left) / 2;
            int y = f(nums, mid);
            if (y <= maxOperations) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private int f(int[] nums, int x) {
        int sum = 0;
        for (int num :
                nums) {
            sum += (num - 1) / x;
        }
        return sum;
    }

    public static void main(String[] args) {
        袋子里最少数目的球_1760 test = new 袋子里最少数目的球_1760();
        test.minimumSize(new int[]{9}, 2);
    }

}
