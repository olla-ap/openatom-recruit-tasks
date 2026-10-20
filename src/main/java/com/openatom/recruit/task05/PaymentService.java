package com.openatom.recruit.task05;

/**
 * 支付服务类。
 * 负责统一捕获支付过程中的异常：能处理的就地处理，不能处理的包装后重新抛出，
 * 并且无论成功失败都要执行 finally 中的资源清理。
 */
public class PaymentService {
    public boolean pay(double amount, String transactionId) {
        PaymentProcessor processor = new PaymentProcessor();

        try {
            processor.pay(amount, transactionId); // 此处为可能抛出异常的方法
        } catch (InsufficientFundsException e) {
            // 余额不足：打印水号后按失败返回
            System.out.println("余额不足，流水号为[" + e.getTransactionId() + "]");
            return false;

        } catch (IllegalArgumentException e) {
            // 参数非法：包装成系统维护异常后重新抛出
            throw new SystemMaintenanceException("系统维护中，请稍后再试", e);

        } catch (Exception e) {
            // 兜底：其他未知异常
            System.out.println("发生未知异常:" + e.getMessage()); // 获取错误信息
            return false;

        } finally {
            // 无论走哪个分支，都会执行
            System.out.println("执行资源清理任务...");
        }

        // 没有异常，视为成功
        return true;
    }
}
