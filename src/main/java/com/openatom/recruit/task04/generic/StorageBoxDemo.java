package com.openatom.recruit.task04.generic;

import com.openatom.recruit.task04.encapsulation.Product;
import com.openatom.recruit.task04.inheritance.Drone;
import com.openatom.recruit.task04.inheritance.TransportVehicle;

/**
 * 对比点：如果没有泛型，取出来是 Object，必须写 (Product) 强转，写错类型要到运行期才报错；
 * 有了泛型，类型错误在编译期就会被拦下。
 */
public class StorageBoxDemo {
    public static void main(String[] args) {
        // 1. 装商品的箱子
        // 实例化一个专门存储商品的储物箱
        StorageBox<Product> productBox = new StorageBox<>();
        productBox.storeItem(new Product("P001", "机械键盘", 450.0));
        // 取出储物箱里的物品
        Product product = productBox.retrieveItem();   // 无需强转
        System.out.println("商品储物箱存取测试：成功取出商品 -> " + product.getName());

        // 2. 装运输工具的箱子（父类作类型参数，子类对象可以放入）
        // 实例化一个专门存储运输工具的储物箱
        StorageBox<TransportVehicle> vehicleBox = new StorageBox<>();
        Drone drone = new Drone("D-007", 39.9, 116.4);
        vehicleBox.storeItem(drone);
        TransportVehicle vehicle = vehicleBox.retrieveItem();   // 无需强转
        System.out.println("设备储物箱存取测试：成功取出设备 -> " + vehicle);

        // 3. 泛型带来的编译期保护：下面这行如果放开就会编译报错
        // StorageBox<Product> box = new StorageBox<>();
        // box.storeItem(drone);   // 编译错误：Drone 不是 Product
    }
}
