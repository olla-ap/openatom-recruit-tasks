package com.openatom.recruit.task06;

import java.util.List;

/**
 * 订单实体类
 */
public class Order implements Comparable<Order> {

    private String orderId; // 订单号
    private String customerName; // 客户姓名
    private double amount; // 定单金额
    private List<String> tags; //商品标签

    public Order(String orderId, String customerName, double amount, List<String> tags) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
        this.tags = tags;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }

    public List<String> getTags() {
        return tags;
    }


    // 按金额降序排列
    public int compareTo(Order other) {
        int byAmount = Double.compare(other.amount, this.amount); // 降序：other vs this
        if (byAmount != 0) {
            return byAmount;
        }
        return this.orderId.compareTo(other.orderId); // 升序
    }

    @Override
    public String toString() {
        return "[" + orderId + "] " + customerName + " 金额:" + amount + " 标签:" + tags;
    }
}
