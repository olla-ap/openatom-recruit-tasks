package com.openatom.recruit.task04.generic;

// T 是类型参数，实例化时才确定具体类型，取出时无需强制类型转换。
// 定义一个泛型类
public class StorageBox<T> {
    // 泛型属性：只能存放 T 类型（或其子类）的对象
    private T item;

    /**
     * 存入物品
     */
    public void storeItem(T item) {
        this.item = item;
    }

    /**
     * 取出物品，返回值直接就是 T，编译期即完成类型检查（返回值类型由T决定）
     */
    public T retrieveItem() {
        return item;
    }

    /**
     * 取出并清空
     */
    public T takeOut() {
        T current = item;
        item = null;
        return current;
    }
    // 判断容器是否为空的方法
    public boolean isEmpty() {
        return item == null;
    }
}
