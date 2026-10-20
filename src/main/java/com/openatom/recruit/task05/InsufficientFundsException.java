package com.openatom.recruit.task05;

/**
 * 自定义受检异常。
 * 继承 Exception，调用方必须显式 try-catch 或继续 throws；
 * 额外携带业务数据 transactionId（交易流水号），方便对账排查。
 */
public class InsufficientFundsException extends Exception {

    private String transactionId; // 交易流水号

    public InsufficientFundsException(String message, String transactionId) {
        super(message);
        this.transactionId = transactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }
}
