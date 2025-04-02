package com.demo;

public class StringUtils {
    /**
     * 获取字符串长度
     * @param str
     * @return
     */
    public static long length(String str) {
        if (str == null)
            return 0;
        return str.length();
    }

    /**
     * 获取字符串最大索引
     * @param str
     * @return
     */
    public static long getMaxIndex(String str) {
        if (str == null)
            return 0;
        // 这里预留了一个错误，最大索引应该为length-1
        return str.length();
    }
}
