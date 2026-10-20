package com.openatom.recruit.task02;
public class VariableSwapper {

    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println("交换前: a=" + a + ", b=" + b);
        // 不使用临时变量完成交换
        // 加减法（算数运算符）
        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("交换后: a=" + a + ", b=" + b);

//        异或 ^ 也能完成交换
//        a = a ^ b;
//        b = a ^ b;
//        a = a ^ b;
//        System.out.println("交换后: a=" + a + ", b=" + b);
    }
}
