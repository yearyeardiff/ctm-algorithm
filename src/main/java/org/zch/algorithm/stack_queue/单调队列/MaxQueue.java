package org.zch.algorithm.stack_queue.单调队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/dui-lie-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxQueue {
    private Deque<Integer> orderQueue = new LinkedList<>();
    private Deque<Integer> queue = new LinkedList<>();

    /**
     * 单调队集合：https://leetcode.cn/problems/shortest-subarray-with-sum-at-least-k/solution/liang-zhang-tu-miao-dong-dan-diao-dui-li-9fvh/
     *
     *
     * 单调递减队列
     */
    public MaxQueue() {

    }

    public int max_value() {
        return orderQueue.peekFirst() == null ? -1 : orderQueue.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);

        while (!orderQueue.isEmpty() && orderQueue.getLast() < value) {
            orderQueue.removeLast();
        }
        orderQueue.offer(value);
    }

    public int pop_front() {
        Integer result = queue.peekFirst();
        if (result == null) {
            return -1;
        }
        if (result == max_value()) {
            orderQueue.poll();
        }
        return queue.removeFirst();
    }

    public static void main(String[] args) {
        // ["MaxQueue","max_value","pop_front","pop_front","push_back","push_back","push_back","pop_front","push_back","pop_front"]
        //[[],[],[],[],[94],[16],[89],[],[22],[]]

        // [null,-1,-1,-1,null,null,null,94,null,16]

        MaxQueue maxQueue = new MaxQueue();
        maxQueue.max_value();
        maxQueue.pop_front();
        maxQueue.pop_front();
        maxQueue.push_back(94);
        maxQueue.push_back(16);
        maxQueue.push_back(89);
        maxQueue.pop_front();
        maxQueue.push_back(22);
        System.out.println(maxQueue.pop_front());
    }
}
