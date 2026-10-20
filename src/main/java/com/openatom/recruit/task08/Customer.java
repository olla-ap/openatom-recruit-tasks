package com.openatom.recruit.task08;

/**
 * 第 8 题 Task3：顾客线程，负责取走奶茶。
 */
public class Customer implements Runnable {

    private String customerName;
    private MilkTeaCounter counter;
    private int cupsToDrink;   // 需要喝到的杯数

    public Customer(String customerName, MilkTeaCounter counter, int cupsToDrink) {
        this.customerName = customerName;
        this.counter = counter;
        this.cupsToDrink = cupsToDrink;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < cupsToDrink; i++) {
                counter.take(customerName);   // 取一杯（空了会在这里 wait）
                Thread.sleep(150);            // 模拟喝奶茶耗时
            }
            System.out.println("[" + customerName + "]已喝到 " + cupsToDrink + " 杯，满足了");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("[" + customerName + "]线程被中断");
        }
    }
}
