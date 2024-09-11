package com.demo.file;

import java.io.File;

/**
 * File搜索文件（查询多级目录文件）
 */
public class FileDemo05 {
    public static void main(String[] args) {
        searchFile(new File("D:/"), "demo.txt");
    }

    /**
     * 搜索文件夹下的某个文件
     * @param dir
     * @param fileName
     */
    public static void searchFile(File dir, String fileName) {
        // 1. 校验文件夹
        if (null == dir || !dir.exists() || dir.isFile()) {
            return;
        }
        // 2. 获取一级文件对象
        File[] files = dir.listFiles();
        // 3.判断当前目录是否存在一级文件对象
        if (null != files && files.length > 0) {
            // 4. 遍历一级文件对象
            for (File file : files) {
                if (file.isFile()) { // 是文件，判断文件是否为要搜索的文件
                    if (file.getName().contains(fileName)) {
                        System.out.println("找到了：" + file.getAbsolutePath());
                    }
                } else { // 是文件夹，递归
                    searchFile(file, fileName);
                }
            }
        }
    }
}
