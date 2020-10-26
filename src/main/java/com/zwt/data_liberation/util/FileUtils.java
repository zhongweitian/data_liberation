package com.zwt.data_liberation.util;

import com.zwt.data_liberation.callback.OnReadCallback;

import java.io.*;
import java.util.List;

/**
 * @author WT ZHONG
 * @version 1.0
 * @date 2020/10/25 17:31
 * 文件读写工具类
 */
public class FileUtils {
    /**
     * 遍历文件夹,返回文件名列表
     * @param path 当前路径
     */
    public static void traverseFolder(String path, List<String> fileNameList) {
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null == files || files.length == 0) {
                System.out.println("文件夹是空的!");
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        traverseFolder(file2.getAbsolutePath(), fileNameList);
                    } else {
                        fileNameList.add(file2.getName());
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }

    /**
     * 逐行读取文件
     * @param pathname 路径名
     * @param callback 回调方法
     */
    public static void readFile(String pathname, OnReadCallback callback) {
        File f = new File(pathname);
        //创建文件缓存流
        try (
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr)
        ) {
            while (true) {
                //逐行读取
                String line = br.readLine();
                if (null == line)
                    break;
                if (line.contains("script")) {
                    System.out.println("读到结尾");
                    break;
                }
                callback.onReadLine(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveFile(File file, String content) throws IOException {
        Writer writer = new FileWriter(file);
        writer.write(content);
        writer.close();
    }
}
