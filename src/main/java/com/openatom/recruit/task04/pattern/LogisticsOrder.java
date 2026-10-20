package com.openatom.recruit.task04.pattern;

/**
 * Task3：建造者模式。
 * 订单只有订单号必填，其他参数选填；用静态内部类 Builder 逐步组装，
 * 每个 set 方法 return this，从而支持链式调用。
 */
public class LogisticsOrder { // 物流订单类

    private final String orderId;        // 订单号：必填
    private final String sender;         // 寄件人：选填
    private final String receiver;       // 收件人：选填
    private final boolean fragile;       // 选填：是否易碎
    private final double insuredAmount;  // 选填：保价金额

    /**
     * 私有构造器，只允许 Builder 来创建对象
     */
    private LogisticsOrder(Builder builder) {
        this.orderId = builder.orderId;
        this.sender = builder.sender;
        this.receiver = builder.receiver;
        this.fragile = builder.fragile;
        this.insuredAmount = builder.insuredAmount;
    }

    public String getOrderId() {
        return orderId;
    }
    public String getSender() {
        return sender;
    }
    public String getReceiver() {
        return receiver;
    }
    public boolean isFragile() {
        return fragile;
    }
    public double getInsuredAmount() {
        return insuredAmount;
    }


    public void printInfo() {
        System.out.println("运单生成：订单号[" + orderId + "], 寄件人[" + sender + "], 收件人[" + receiver
                + "], 易碎品[" + fragile + "], 保价[" + insuredAmount + "元]");
    }

    /**
     * 静态内部类：持有一份和外部类相同的字段，逐步赋值，最后 build 出外部类对象
     */
    public static class Builder {
    // 包含和上面同样的属性
        private String orderId;
        private String sender;
        private String receiver;
        private boolean fragile;
        private double insuredAmount;

        /**
         * 必填项放在构造器里，保证创建时一定被赋值
         */
        public Builder(String orderId) {
            this.orderId = orderId; // 必填
        }
        // 选填项也有相应的赋值方法
        public Builder sender(String sender) {
            this.sender = sender; // 1.把传进来的值存到Builder自己的属性里
            return this; // 2.返还自己
        }
        public Builder receiver(String receiver) {
            this.receiver = receiver;
            return this;
        }
        public Builder fragile(boolean fragile) {
            this.fragile = fragile;
            return this;
        }
        public Builder insuredAmount(double insuredAmount) {
            this.insuredAmount = insuredAmount;
            return this;
        }
        public LogisticsOrder build() {
            return new LogisticsOrder(this);
        }


//        public Builder(String sender, String receiver, boolean fragile, double insuredAmount) {
//            this.sender = sender;
//            this.receiver = receiver;
//            this.fragile = fragile;
//            this.insuredAmount = insuredAmount;

    }
}
