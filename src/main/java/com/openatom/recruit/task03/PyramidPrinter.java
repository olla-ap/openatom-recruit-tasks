package com.openatom.recruit.task03;
public class PyramidPrinter {

    // 打印空心金字塔
    public void printPyramid(int layer) {
        if (layer <= 0) {
            System.out.println("层数必须大于 0");
            return;
        }

        // 外层 for 控制行，内层 for 控制每行先打印的空格与星号
        for (int i = 1; i <= layer; i++) {
            // 1. 打印左侧空格，让图形居中：第 i 行需要 layer - i 个空格（打印左半部分空格）
            for (int space = 1; space <= layer - i; space++) {
                System.out.print(" ");
            }

           // 2. 打印本行内容
        if (i == 1) {
            // 顶点：1 个星
            System.out.print("*");
        } else if (i == layer) {
            // 最后一行：全是星，共 2*layer-1 个
            for (int j = 1; j <= 2 * layer - 1; j++) {
                System.out.print("*");
            }
        } // 第一行和最后一行较特殊

        else {
            // 中间行：* + 空格 + *
            // 第i行中间打印i*2-1个空格（找规律）
            System.out.print("*");
            for (int j = 1; j <= 2 * i - 3; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
        }

        System.out.println();
        }
    }
}
