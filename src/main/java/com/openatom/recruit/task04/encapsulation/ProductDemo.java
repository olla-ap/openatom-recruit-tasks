package com.openatom.recruit.task04.encapsulation;
public class ProductDemo {

    public static void main(String[] args) {
        // 用全参构造器创建两个不同商品
        Product keyboard = new Product("P001", "机械键盘", 450.0);
        Product earphone = new Product("P002", "蓝牙耳机", -299.0);

        // 实例方法：必须通过对象调用，读取属性
        keyboard.printInfo();
        earphone.printInfo();

        // 静态方法：通过类名调用，读取商品总数
        System.out.println("系统当前共创建了 " + Product.getTotalCount() + " 个商品实例。");
    }
}
