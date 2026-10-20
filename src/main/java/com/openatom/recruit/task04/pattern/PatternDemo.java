package com.openatom.recruit.task04.pattern;
import com.openatom.recruit.task04.inheritance.TransportVehicle;


public class PatternDemo {
    public static void main(String[] args) {
        // 1. 单例：两次获取，比较是否为同一个对象（== 比较内存地址）
        LogisticsConfig configA = LogisticsConfig.getInstance();
        LogisticsConfig configB = LogisticsConfig.getInstance();
        System.out.println("单例测试：配置类实例A与实例B是否相同？ -> " + (configA == configB));
        System.out.println("当前系统名称：" + configA.getSystemName());


        // 2. 简单工厂：不直接 new 无人机，让工厂去生产
        TransportVehicle vehicle = VehicleFactory.createVehicle("DRONE");
        System.out.println("工厂调度：工厂成功分配 -> " + vehicle + "，计费启动...");
        System.out.println("该设备配送 10kg 费用：" + vehicle.calculateCost(10) + "元");

        // 工厂对未知类型返回 null，调用方需要判空
        TransportVehicle unknown = VehicleFactory.createVehicle("SHIP");
        System.out.println("工厂调度：传入 Ship 的返回结果 -> " + unknown);


        // 3. 建造者：只填需要的选填项，链式调用一步到底
        LogisticsOrder order = new LogisticsOrder.Builder("OD-999")
                .sender("Alice")
                .receiver("Bob")
                .fragile(true)
                .insuredAmount(1000.0)
                .build();
        order.printInfo();
    }
}
