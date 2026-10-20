package com.openatom.recruit.task03;

import java.util.Scanner;


public class ToolboxApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 实例化ScoreEvaluator和PyramidPrinter两个类
        ScoreEvaluator evaluator = new ScoreEvaluator();
        PyramidPrinter printer = new PyramidPrinter();
        ToolboxApp app = new ToolboxApp();

        System.out.println("【欢迎使用多功能工具箱】");

        // 系统菜单与控制循环
        // while(true) 常驻循环，输入 4 时 break 退出
        while (true) {
            System.out.println("1.成绩评定 2.空心金字塔 3.递归阶乘 4.退出系统");
            System.out.print("请选择功能：");
            int choice = scanner.nextInt();

            if (choice == 4) {
                System.out.println("再见");
                break;
            } else if (choice == 1) {
                System.out.print("请输入分数：");
                int score = scanner.nextInt();
                System.out.println("成绩评定：" + evaluator.gradeByIfElse(score));
                System.out.println("成绩评定：" + evaluator.gradeBySwitch(score));
            } else if (choice == 2) {
                // 打印空心金字塔
                System.out.print("请输入金字塔层数：");
                int layer = scanner.nextInt();
                printer.printPyramid(layer);
            } else if (choice == 3) {
                // 调用递归方法计算阶乘
                System.out.print("计算阶乘：");
                int n = scanner.nextInt();
                System.out.println("计算结果：" + app.calculateFactorial(n));
            } else {
                System.out.println("输入有误，请重新选择");
            }
        }

        scanner.close();
    }

    // 定义计算阶乘的方法
    public int calculateFactorial(int n) {
        if (n < 0) {
            System.out.println("负数没有阶乘");
            return -1;// 此处为错误标记，用于退出方法，不返还值
        }
        if (n <= 1) {
            return 1;
        }
        return n * calculateFactorial(n - 1);// 递归方法：自己调用自己，直至程序结束
    }
}
