package com.openatom.recruit.task04.pattern;

import com.openatom.recruit.task04.inheritance.Drone;
import com.openatom.recruit.task04.inheritance.Truck;
import com.openatom.recruit.task04.inheritance.TransportVehicle;

/**
 * Task2：简单工厂模式。
 * 调用方只关心"我要一辆车"，不关心 new 的是哪个子类，实现创建与使用解耦。
 */
public class VehicleFactory {
    // 不想让外界直接new对象/创建对象得到逻辑比较复杂，提供一个静态方法来“生产”方法
    // 静态：属于类本身而非某个对象，调用时直接用类名调用
    public static TransportVehicle createVehicle(String type) {
//        if (type == null) {
//            return null;
//        }
        return switch (type) {
            case "TRUCK" -> new Truck("T-998", "仓库A区");
            case "DRONE" -> new Drone("D-007", 39.9, 116.4);
            default -> null;
        };
    }
}

