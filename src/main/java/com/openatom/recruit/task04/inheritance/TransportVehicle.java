package com.openatom.recruit.task04.inheritance;
public abstract class TransportVehicle {

    // 子类可以直接访问，外部包不能访问
    // 共有属性：名称
    protected String vehicleId;

    public TransportVehicle(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    /**
     * 抽象方法：按重量计算运费，具体规则由子类决定
     */
    // 只定契约不给实现，子类必须重写以提供具体行为
    public abstract double calculateCost(double weight);
}
