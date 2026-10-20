package com.openatom.recruit.task08;

/**
 * 第 8 题 Task4：2 名店员 + 2 名顾客的测试入口。
 * 每个店员做 10 杯（共 20 杯），每个顾客喝 10 杯（共 20 杯），供需平衡。
 */
public class MilkTeaShopDemo {

    public static void main(String[] args) throws InterruptedException {
        MilkTeaCounter counter = new MilkTeaCounter();

        Thread staff1 = new Thread(new Staff("店员-1", counter, 10), "staff-1");
        Thread staff2 = new Thread(new Staff("店员-2", counter, 10), "staff-2");
        Thread customer1 = new Thread(new Customer("顾客-1", counter, 10), "customer-1");
        Thread customer2 = new Thread(new Customer("顾客-2", counter, 10), "customer-2");

        System.out.println("--- 奶茶店开始营业 ---");
        staff1.start();
        staff2.start();
        customer1.start();
        customer2.start();

        // join：等四个线程都执行完毕，主线程再继续
        staff1.join();
        staff2.join();
        customer1.join();
        customer2.join();

        System.out.println("--- 营业结束 ---");
        System.out.println("所有店员已下班，所有顾客都已满足。");
    }
}
