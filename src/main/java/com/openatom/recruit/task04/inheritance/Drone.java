package com.openatom.recruit.task04.inheritance;
/**
 * 与卡车是"兄弟类"，同样继承抽象父类、实现定位接口，但计费公式不同。
 */
public class Drone extends TransportVehicle implements GpsLocatable {
    // 特有属性：坐标
    private double latitude;    // 纬度
    private double longitude;   // 经度

    // 构造方法
    public Drone(String vehicleId, double latitude, double longitude) {
        super(vehicleId);
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * 无人机计费规则：重量 * 15.0
     */
    @Override
    public double calculateCost(double weight) {
        return weight * 15.0;
    }

    @Override
    public String getLocation() {
        return "高空坐标(" + latitude + ", " + longitude + ")";
    }

    @Override
    public String toString() {
        return "无人机 [" + vehicleId + "]";
    }
}
