package com.openatom.recruit.task05;

/**
 * 支付处理类。
 * 按金额的不同取值，分别抛出三种不同的异常，模拟真实网关的分支判断。
 */
public class PaymentProcessor {
    // 告知需要处理异常
    public void pay(double amount, String transactionId) throws InsufficientFundsException {
        // 1. 参数非法：金额为负，属于调用方错误，用原生异常类型IllegalArgumentException
        if (amount < 0) {
            throw new IllegalArgumentException("支付金额不能为负数");
        }

        // 2. 余额不足：需要把流水号带给上层，所以用自定义受检异常
        if (amount > 10000) {
            throw new InsufficientFundsException("余额不足", transactionId);
        }

        // 3. 模拟系统维护：给非受检异常挂上原始异常（异常链）
        if (amount == 500) {
            // 系统维护异常和空指针异常
            throw new SystemMaintenanceException("网络连接超时", new NullPointerException("支付渠道返回了空响应"));
        }

        // 4. 正常支付
        System.out.println("交易[" + transactionId + "]支付成功，金额：" + amount);
    }
}
