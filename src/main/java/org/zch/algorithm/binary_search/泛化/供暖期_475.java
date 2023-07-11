package org.zch.algorithm.binary_search.泛化;

import java.util.Arrays;

public class 供暖期_475 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int left = 0, right = Math.max(houses[houses.length - 1], heaters[heaters.length - 1]);
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(houses, heaters, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private boolean check(int[] houses, int[] heaters, int len) {
        int lastIdx = 0;
        for (int house : houses) {
            boolean check = false;
            while (lastIdx < heaters.length) {
                int heater = heaters[lastIdx];
                if (house <= heater &&  house >= heater - len) {
                    check = true;
                    break;
                } else if (house > heater && house <= heater + len) {
                    check = true;
                    break;
                }
                lastIdx++;
            }
            if (!check) {
                return false;
            }
        }
        return true;
    }
}
