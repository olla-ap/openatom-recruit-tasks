package com.openatom.recruit.task06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 第 6 题 Task3
 */
public class OrderAnalyzerDemo {

    public static void main(String[] args) {
        OrderAnalyzer analyzer = new OrderAnalyzer();
        // 增加订单
        analyzer.add(new Order("O001", "Alice", 150.0, new ArrayList<>(Arrays.asList("电子", "数码"))));
        analyzer.add(new Order("O002", "Bob", -50.0, new ArrayList<>(Arrays.asList("服装"))));
        analyzer.add(new Order("O003", "Alice", 200.0, new ArrayList<>(Arrays.asList("图书", "电子"))));
        analyzer.add(new Order("O004", "Charlie", 200.0, new ArrayList<>(Arrays.asList("生鲜"))));
        analyzer.add(new Order("O005", "Bob", 300.0, new ArrayList<>(Arrays.asList("服装", "户外"))));
        // 按默认规则排序再打印
        System.out.println("=== 原始订单（按默认规则排序：金额降序，金额相同按订单号升序）===");
        analyzer.sortByDefaultRule();
        printOrders(analyzer.getOrders());

        System.out.println("=== 删除金额 <= 0 的无效订单 ===");
        analyzer.removeInvalidOrders();
        System.out.println("剩余订单数：" + analyzer.getOrders().size());

        System.out.println("=== 全部标签（去重）===");
        Set<String> tags = analyzer.getAllUniqueTags();
        System.out.println(tags);

        System.out.println("=== 每个客户的总消费 ===");
        Map<String, Double> spendMap = analyzer.getCustomerSpendMap();
        // 利用.entryset()方法同时返还客户名和金额
        for (Map.Entry<String, Double> entry : spendMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + "元");
        }

        System.out.println("=== 按客户姓名升序排列（新集合，不影响原列表）===");
        printOrders(analyzer.sortOrdersByCustomerName());
    }

    private static void printOrders(List<Order> orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
