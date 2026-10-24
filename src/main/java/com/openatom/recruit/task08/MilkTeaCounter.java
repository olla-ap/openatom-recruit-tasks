package com.openatom.recruit.task08;

/**
 * 第 8 题 Task1：吧台（共享容器）。
 * 店员和顾客是两个线程，同时操作同一个吧台，因此用 synchronized 保证互斥，
 * 用 wait() / notifyAll() 做"满了就等、有了就取"的协作。
 */
public class MilkTeaCounter {

    // 吧台最多放 5 杯
    private static final int MAX_CAPACITY = 5;
    private int milkTeaCount = 0;

    /**
     * 店员放奶茶：吧台满了就等待，放完通知顾客
     */

    // synchronized关键字：保证同一时刻最多只有一个线程被执行
    public synchronized void put(String staffName) throws InterruptedException {
        // 用 while 而不是 if：被唤醒后要重新检查条件，防止虚假唤醒
        while (milkTeaCount >= MAX_CAPACITY) {
            // 释放锁，线程进入等待状态
            wait();
        }

        milkTeaCount++;
        System.out.println("[" + staffName + "]制作了奶茶，吧台当前数量：" + milkTeaCount);

        // 唤醒所有等待的线程（顾客和店员）
        notifyAll();
    }

    /**
     * 顾客取奶茶：吧台空了就等待，取完通知店员
     */
    public synchronized void take(String customerName) throws InterruptedException {
        while (milkTeaCount <= 0) {
            wait();
        }

        milkTeaCount--;
        System.out.println("[" + customerName + "]取走了奶茶，吧台剩余数量：" + milkTeaCount);

        notifyAll();
    }
}
