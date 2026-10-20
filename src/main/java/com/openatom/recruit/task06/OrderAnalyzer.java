package com.openatom.recruit.task06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 订单分析器。
 * 覆盖集合的四个常见操作：排序、去重、分组统计、遍历。
 */
public class OrderAnalyzer {
    private List<Order> orders = new ArrayList<>(); // 创建一个Order的对象数组


    // 几个常见操作
    /**
     * 加入一笔订单
     */
    public void add(Order order) {
        orders.add(order);
    }

    /**
     * 删除所有金额 <= 0 的无效订单。
     * 倒序遍历，避免正序删除时后面的元素前移导致漏删。
     */
    public void removeInvalidOrders() {
        for (int i = orders.size() - 1; i >= 0; i--) {
            if (orders.get(i).getAmount() <= 0) {
                System.out.println("移除无效订单：" + orders.get(i).getOrderId()
                        + "，金额为 " + orders.get(i).getAmount());
                orders.remove(i);
            }
        }
    }

    /**
     * 汇总所有标签并去重。
     * 用 LinkedHashSet 既去重，又能保持插入顺序，输出更稳定。
     */
    public Set<String> getAllUniqueTags() {
        Set<String> allTags = new LinkedHashSet<>();
        // 对orders里的每一个订单进行获取标签操作
        for (Order order : orders) {
            allTags.addAll(order.getTags());
        }
        return allTags;
    }

    /**
     * 按客户姓名分组累加消费金额。
     * 用 TreeMap 让输出按姓名有序，便于阅读。
     */
    public Map<String, Double> getCustomerSpendMap() {
        Map<String, Double> spendMap = new TreeMap<>();
        // 此时的spendMap相当于一个储物柜，Key（键），Value（值）
        for (Order order : orders) {
            String name = order.getCustomerName();
            if (spendMap.containsKey(name)) {
                // 已有记录：取旧值累加
                spendMap.put(name, spendMap.get(name) + order.getAmount());
            } else {
                // 首次出现：直接放入本单金额
                spendMap.put(name, order.getAmount());
            }
        }
        return spendMap;
    }

    /**
     * 返回一个新集合，按客户姓名升序排列，不改动原有列表
     */
    public List<Order> sortOrdersByCustomerName() {
        List<Order> copy = new ArrayList<>(orders);
        Collections.sort(copy, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.getCustomerName().compareTo(o2.getCustomerName());
            }
        });
        return copy;
    }

    /**
     * 按 Order 自己定义的默认规则排序（金额降序、金额相同按订单号升序）
     */
    // 这里的Collections.sort方法来源于comparable<>接口
    public void sortByDefaultRule() {
        Collections.sort(orders);
    }

    public List<Order> getOrders() {
        return orders;
    }
}
