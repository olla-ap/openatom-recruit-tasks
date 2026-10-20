package com.openatom.recruit.task07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Task3：生成测试文件，完成"分片 -> 合并 -> 一致性校验"的完整验证。
 */
public class FileTransferDemo {

    public static void main(String[] args) throws IOException {
        // 1. 准备目录与测试文件（约 250KB，按 100KB 切片必然超过 3 片）
        File workDir = new File("temp/file-demo");
        if (!workDir.exists()) {
            workDir.mkdirs();
        }
        File sourceFile = new File(workDir, "myWords.txt");
        createTestFile(sourceFile, 5000);
        System.out.println("测试源文件：" + sourceFile.getAbsolutePath() + "，大小：" + sourceFile.length() + " 字节");

        // 2. 分片：每片 100000 字节
        File partDir = new File(workDir, "parts");
        long chunkSize = 100000;
        System.out.println("--- 开始分片，每片上限 " + chunkSize + " 字节 ---");
        FileChunkTransfer.splitFile(sourceFile.getAbsolutePath(), partDir.getAbsolutePath(), chunkSize);
        int partCount = countParts(partDir, sourceFile.getName());
        System.out.println("分片总数：" + partCount);

        // 3. 合并到新文件
        File mergedFile = new File(workDir, "myWords_merged.txt");
        System.out.println("--- 开始合并 ---");
        FileChunkTransfer.mergeFile(partDir.getAbsolutePath(), sourceFile.getName(), mergedFile.getAbsolutePath());

        // 4. 校验：先比大小，再逐字节比较内容
        System.out.println("--- 一致性校验 ---");
        System.out.println("源文件大小：" + sourceFile.length() + " 字节，合并文件大小：" + mergedFile.length() + " 字节");
        boolean sameSize = sourceFile.length() == mergedFile.length();
        boolean sameContent = sameSize && compareFiles(sourceFile, mergedFile);
        System.out.println("两个文件内容是否完全一致：" + sameContent);

        System.out.println("剩余分片数量：" + countParts(partDir, sourceFile.getName()));
    }

    /**
     * 生成测试用文本文件，每行一句话，共 lineCount 行
     */
    private static void createTestFile(File file, int lineCount) throws IOException {
        FileOutputStream out = new FileOutputStream(file);
        for (int i = 1; i <= lineCount; i++) {
            String line = "第 " + i + " 行：智能仓储系统的分片传输测试数据 ABCDEFGHIJKLMNOPQRSTUVWXYZ 0123456789\r\n";
            out.write(line.getBytes("UTF-8"));
        }
        out.close();
    }

    /**
     * 逐字节比较两个文件是否完全一致
     */
    private static boolean compareFiles(File file1, File file2) throws IOException {
        FileInputStream in1 = new FileInputStream(file1);
        FileInputStream in2 = new FileInputStream(file2);
        int b1;
        int b2;
        while (true) {
            b1 = in1.read();
            b2 = in2.read();
            if (b1 != b2) {
                in1.close();
                in2.close();
                return false;
            }
            if (b1 == -1) {
                break;   // 两个文件同时读完
            }
        }
        in1.close();
        in2.close();
        return true;
    }

    /**
     * 统计目录下属于该文件的分片个数
     */
    private static int countParts(File dir, String originalFileName) {
        File[] files = dir.listFiles();
        int count = 0;
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().startsWith(originalFileName + ".part")) {
                    count++;
                }
            }
        }
        return count;
    }
}
