package com.openatom.recruit.task08;

/**
 * 第 8 题 Task2：店员线程，负责制作奶茶。
 * 实现 Runnable 接口，把"任务"和"线程"分开，便于多个线程共用一个任务对象。
 */
public class Staff implements Runnable {

    private String staffName;
    private MilkTeaCounter counter;
    private int cupsToMake;   // 需要制作的杯数

    public Staff(String staffName, MilkTeaCounter counter, int cupsToMake) {
        this.staffName = staffName;
        this.counter = counter;
        this.cupsToMake = cupsToMake;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < cupsToMake; i++) {
                counter.put(staffName);       // 放一杯到吧台（满了会在这里 wait）
                Thread.sleep(100);            // 模拟制作耗时
            }
            System.out.println("[" + staffName + "]已完成 " + cupsToMake + " 杯，下班了");
        } catch (InterruptedException e) {
            // 线程被中断时恢复中断标记，让上层知道发生过中断
            Thread.currentThread().interrupt();
            System.out.println("[" + staffName + "]线程被中断");
        }
    }
}
