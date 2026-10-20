package com.openatom.recruit.task01;
public class HelloWorld {

    public static void main(String[] args) {
        // 打印 Hello world
        System.out.println("Hello world");

        // 实例化 GreetingService类，再调用它的方法（跨类调用）
        GreetingService greetingService = new GreetingService();
        greetingService.sayHello("OpenAtom");
    }
}
