package com.openatom.recruit.task05;

/**
 * 第 5 题 Task4：四种场景的测试入口。
 * main 里对可能抛出的异常都做了捕获，避免某次失败导致整个程序崩溃。
 */
public class PaymentDemo {

    public static void main(String[] args) {
        PaymentService service = new PaymentService();

        // 场景一：金额为负 —— 服务层包装成系统维护异常后重新抛出，这里捕获
        System.out.println("--- 场景一：金额 -100 元 ---");
        try {
            boolean result = service.pay(-100, "TXN-001");
            System.out.println("支付结果：" + result);
        } catch (SystemMaintenanceException e) {
            System.out.println("捕获到异常：" + e.getMessage());
            System.out.println("原始异常类型：" + e.getCause());
        }

        // 场景二：金额超过 10000 —— 余额不足，服务层返回 false
        System.out.println("--- 场景二：金额 20000 元 ---");
        System.out.println("支付结果：" + service.pay(20000, "TXN-002"));

        // 场景三：金额等于 500 —— 触发系统维护异常（带异常链），被兜底分支捕获
        System.out.println("--- 场景三：金额 500 元 ---");
        System.out.println("支付结果：" + service.pay(500, "TXN-003"));

        // 场景四：正常支付
        System.out.println("--- 场景四：金额 300 元 ---");
        System.out.println("支付结果：" + service.pay(300, "TXN-004"));
    }
}
