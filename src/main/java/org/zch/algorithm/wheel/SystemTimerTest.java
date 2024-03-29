package org.zch.algorithm.wheel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * https://www.jianshu.com/p/837ec4ea95c1
 * https://www.jianshu.com/p/0dc512ec0138
 * https://zhuanlan.zhihu.com/p/121483218
 */
public class SystemTimerTest {
    //驱动时间轮向前的线程
    private static ExecutorService executorService = Executors.newFixedThreadPool(1);
    public static SystemTimer timer = new SystemTimer("test", 1000L, 5, System.currentTimeMillis());


    public static void runTask() throws Exception {
        for (int i = 0; i < 10000; i += 1000) {
            // 添加任务，每个任务间隔1s
            timer.add(new TimerTask(i) {
                @Override
                public void run() {
                    System.out.println("运行testTask的时间: " + System.currentTimeMillis());
                }
            });
        }
    }

    public static void main(String[] args) throws Exception {
        runTask();

        executorService.submit(() -> {
            while (true) {
                try {
                    // 驱动时间轮线程间隔0.2s驱动
                    timer.advanceClock(200L);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        Thread.sleep(1000000);
        timer.shutdown();
        executorService.shutdown();
    }
}