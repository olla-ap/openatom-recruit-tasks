package com.openatom.recruit.task04.dynamicarray;
// 要求：封装一个可以自动扩容的动态数组类
// 底层仍是一个定长 Object[]，通过在"装满"时新建一个 2 倍长度的数组来实现自动扩容。
public class MyArrayList<T> {

    // Task1：底层定长数组 + 实际元素个数（故意把初始容量设成 3，方便触发扩容）
    private Object[] elements; // 创建名为elements的对象数组
    private int size;
    // 构造方法对属性初始化
    public MyArrayList() {
        this.elements = new Object[3];
        this.size = 0;
    }


    // Task2：添加元素，满了先扩容再存
    public void add(T element) {
        // 1. 容量检查：size 等于数组长度说明已经装满
        if (size == elements.length) {
            int oldCapacity = elements.length;
            Object[] newElements = new Object[oldCapacity * 2]; // "装满"时新建一个 2 倍长度的数组来实现自动扩容
            // 2. 把老数组的数据逐个复制到新数组
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }
            // 3. 让 elements 指向新数组，老数组等待垃圾回收
            elements = newElements;
            System.out.println("触发底层扩容！当前数组容量由 " + oldCapacity + " 扩容至 " + elements.length);
        }

        // 4. 存入新元素，计数加一
        elements[size] = element; // 实际存入的是第（size+1）个对象
        size++;
        System.out.println("成功添加：" + element);
    }

    // Task3：按下标查询，先做边界安全检查
    public T get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("下标越界：index=" + index + "，当前元素个数为 " + size);
            return null;
        }
        // 数组声明为 Object[]，取出来要转回 T（向下转型）
        return (T) elements[index];
    }


    // Task4：按下标（index）删除，核心是后面的元素整体前移一位
    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("下标越界：index=" + index + "，当前元素个数为 " + size);
            return;
        }

        T removed = get(index);   // 先记下被删的元素，用于打印
        // 从 index 开始，把后一个元素覆盖到前一个位置
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        // 最末尾的位置置空并让 size 减一
        elements[size - 1] = null;
        size--;

        System.out.println("删除了索引[" + index + "]的元素(" + removed + ")");
    }

    public int size() {
        return size;
    }
}
