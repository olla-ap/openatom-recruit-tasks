package com.openatom.recruit.task02;
public class ProductBilling {

    public static void main(String[] args) {
        // 声明并初始化商品变量
        String productName = "机械键盘"; // 商品名称
        double unitPrice = 150.0;      // 商品单价
        int stock = 20;                 // 库存
        boolean onPromotion = false;    // 是否处于促销中

        // 购买数量与总价
        int buyCount = 2;
        double totalPrice = unitPrice * buyCount;

        // 包邮条件 = 总价 >= 100 元 或者 正在促销
        boolean freeShipping = totalPrice >= 100 || onPromotion;

        // 打印完整的商品信息和包邮判定信息
        System.out.println("商品：" + productName + "，单价：" + unitPrice + "元，促销中：" + onPromotion
                + "，购买" + buyCount + "件，总价为：" + totalPrice + "元");
        System.out.println("是否享受包邮：" + freeShipping);


    }
}
