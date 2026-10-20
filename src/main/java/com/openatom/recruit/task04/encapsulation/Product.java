package com.openatom.recruit.task04.encapsulation;
public class Product {

    // 私有属性，外部只能通过公有的 Getter / Setter 访问
    // 普通成员：不同对象有不同属性
    private String productId; // 商品编号
    private String name; // 名称
    private double price; // 价格
    // 静态成员记录创建总数，特点：所有对象共享同一份
    private static int totalProductCount = 0; // 商品总数



   // 空参构造（方便后续通过setter方法检查数据合法性，方便继承等等）
    public Product() {
        totalProductCount++;
    }
    // 带全部参数的构造（直接完成所有属性的初始化）
    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        totalProductCount++;
    }
    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
            this.price = price;
    }
    public static int getTotalProductCount() {
        return totalProductCount;
    }
    public static void setTotalProductCount(int totalProductCount) {
        Product.totalProductCount = totalProductCount; // 静态成员对应静态方法，不能用this关键字
    }



    // 提供静态方法返还商品总数值
    public static int getTotalCount() {
        return totalProductCount;
    }
    /**
     * 实例方法：打印当前对象自己的信息
     */
    public void printInfo() {
        System.out.println("商品信息：[" + productId + "] " + name + ", 价格: " + price + "元");
    }
}
