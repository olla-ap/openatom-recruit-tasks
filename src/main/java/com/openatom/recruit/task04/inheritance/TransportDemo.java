package com.openatom.recruit.task04.inheritance;
public class TransportDemo {

    public static void main(String[] args) {
        // 父类引用 -> 子类对象（多态）（接口向上转型）
        TransportVehicle truck = new Truck("T-998", "仓库A区");
        TransportVehicle drone = new Drone("D-007", 39.9, 116.4);

        double weight = 10;   // 统一按 10kg 计算

        // 定位方法属于接口，父类了里面没有，需要把父类引用转成接口类型来调用（强制向下转型/利用instanceof判断）
        if (truck instanceof GpsLocatable) {
            GpsLocatable truckGps = (GpsLocatable) truck;
            System.out.println(truck + " 当前位置：" + truckGps.getLocation()
                    + " | 配送" + (int) weight + "kg,货物费用：" + truck.calculateCost(weight) + "元");
            // 使用 truckGps
        }
        if (drone instanceof GpsLocatable) {
            GpsLocatable dronesGps = (GpsLocatable) drone;
            // 使用 droneGps
            System.out.println(drone + " 当前位置：" + dronesGps.getLocation()
                    + " | 配送" + (int) weight + "kg货物费用：" + drone.calculateCost(weight) + "元");
        }


    }
}
