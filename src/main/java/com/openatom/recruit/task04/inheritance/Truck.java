package com.openatom.recruit.task04.inheritance;
// 继承abstract class TransportVehicle，实现 interface GpsLocatable
public class Truck extends TransportVehicle implements GpsLocatable {
    // 特有属性：位置
    private String location;

    // 构造方法
    public Truck(String vehicleId, String location) {
        super(vehicleId);   // 调用父类构造器完成 vehicleId 的初始化
        this.location = location;
    }

    /**
     * 卡车计费规则：重量 * 5.0
     */
    @Override
    public double calculateCost(double weight) {
        return weight * 5.0;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "卡车 [" + vehicleId + "]";
    }
}
