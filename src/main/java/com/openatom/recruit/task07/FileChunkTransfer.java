package com.openatom.recruit.task07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 大文件分片与合并。
 */
public class FileChunkTransfer {

    // 缓冲区大小：8KB，读写都经过它，避免一个字节一个字节地读
    private static final int BUFFER_SIZE = 8192;

    /**
     * Task1：把源文件按 chunkSize 切成若干分片，命名规则为 "源文件名.partX"
     */
    // 文件分片方法（源文件路径，分片输出目录路径，每个分片最大大小）
    public static void splitFile(String sourceFilePath, String outputDirPath, long chunkSize) throws IOException {
        File sourceFile = new File(sourceFilePath);
        File outputDir = new File(outputDirPath);

        if (!sourceFile.exists() || !sourceFile.isFile()) {
            System.out.println("源文件不存在：" + sourceFilePath);
            return;
        }
        if (chunkSize <= 0) {
            System.out.println("分片大小必须大于 0");
            return;
        }
        if (!outputDir.exists()) {
            outputDir.mkdirs();   // make directions:目录不存在时先创建
        }

        long fileLength = sourceFile.length();
        byte[] buffer = new byte[BUFFER_SIZE];
        FileInputStream in = new FileInputStream(sourceFile);

        int partIndex = 1;      // 分片序号从 1 开始
        long start = 0;         // 当前分片在源文件中的起始位置

        while (start < fileLength) {
            // 本片大小：通常就是 chunkSize，最后一片可能不足
            long currentChunkSize = Math.min(chunkSize, fileLength - start);

            File partFile = new File(outputDir, sourceFile.getName() + ".part" + partIndex);
            FileOutputStream out = new FileOutputStream(partFile);

            long written = 0;
            while (written < currentChunkSize) {
                // 每次最多读 buffer 长度，并且不能超过本片剩余量
                int readLength = in.read(buffer, 0, (int) Math.min(BUFFER_SIZE, currentChunkSize - written));
                if (readLength == -1) {
                    break;   // 文件已读完（理论上不会提前触发）
                }
                out.write(buffer, 0, readLength);
                written += readLength;
            }

            out.close();   // 每个分片用完立刻关闭，释放句柄
            System.out.println("已生成分片：" + partFile.getName() + "，大小：" + partFile.length() + " 字节");

            partIndex++;
            start += currentChunkSize;
        }

        in.close();
    }

    /**
     * Task2：把分片按序号合并成完整文件，合并完成后删除所有分片
     */
    public static void mergeFile(String targetDirPath, String originalFileName, String mergedFilePath) throws IOException {
        File targetDir = new File(targetDirPath);
        File[] files = targetDir.listFiles();
        if (files == null) {
            System.out.println("分片目录不存在：" + targetDirPath);
            return;
        }

        // 1. 找出所有属于该文件的分片
        List<File> parts = new ArrayList<>();
        for (File file : files) {
            if (file.isFile() && file.getName().startsWith(originalFileName + ".part")) {
                parts.add(file);
            }
        }
        if (parts.isEmpty()) {
            System.out.println("没有找到任何分片：" + originalFileName + ".partX");
            return;
        }

        // 2. 按分片后缀数字排序（字符串排序会把 part10 排到 part2 前面，必须转成数字比）
        Collections.sort(parts, new Comparator<File>() {
            @Override
            public int compare(File f1, File f2) {
                return parsePartIndex(f1) - parsePartIndex(f2);
            }
        });

        // 3. 依次读取每个分片，追加写入到最终文件
        byte[] buffer = new byte[BUFFER_SIZE];
        FileOutputStream out = new FileOutputStream(mergedFilePath);
        for (File part : parts) {
            FileInputStream in = new FileInputStream(part);
            int readLength;
            while ((readLength = in.read(buffer)) != -1) {
                out.write(buffer, 0, readLength);
            }
            in.close();
        }
        out.close();

        System.out.println("合并完成：" + mergedFilePath + "，共合并 " + parts.size() + " 个分片");

        // 4. 合并成功后删除分片文件
        for (File part : parts) {
            if (part.delete()) {
                System.out.println("已删除分片：" + part.getName());
            }
        }
    }

    /**
     * 从 xxx.part3 这样的文件名中解析出序号 3
     */
    private static int parsePartIndex(File file) {
        String name = file.getName();
        int index = name.lastIndexOf(".part");
        return Integer.parseInt(name.substring(index + ".part".length()));
    }
}
