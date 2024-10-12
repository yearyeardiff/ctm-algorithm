package org.zch.algorithm.常用算法;

import java.util.*;

public class 前k个高频元素_347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cntMap = new HashMap<>();

        for (int num : nums) {
            int cnt = cntMap.getOrDefault(num, 0);
            cntMap.put(num, cnt + 1);
        }

        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(cntMap::get));

        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()){
            if (queue.size() < k) {
                queue.offer(entry.getKey());
            } else {
                if (cntMap.get(queue.peek()) < entry.getValue()) {
                    queue.poll();
                    queue.offer(entry.getKey());
                }
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

}
