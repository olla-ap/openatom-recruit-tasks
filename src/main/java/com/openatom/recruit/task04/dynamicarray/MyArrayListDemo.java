package com.openatom.recruit.task04.dynamicarray;
public class MyArrayListDemo {

    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();

        // 初始容量 3，存到第 4 个时必然扩容（3 -> 6）
        list.add("单号A");
        list.add("单号B");
        list.add("单号C");
        list.add("单号D");
        list.add("单号E");

        // 查询索引 2
        System.out.println("获取索引[2]的元素：" + list.get(2));

        // 删除索引 1，后面的元素会整体前移
        list.remove(1);
        System.out.println("验证移位，此时索引[1]的元素变为了：" + list.get(1));

        // 越界测试：当前只有 4 个元素，索引 10 不合法
        System.out.println("越界测试返回：" + list.get(10));
    }
}
