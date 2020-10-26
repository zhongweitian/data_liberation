package com.zwt.data_liberation.util;

/**
 * @author WT ZHONG
 * @version 1.0
 * @date 2020/5/5 14:21
 * 自动补齐空格工具
 */
public class FormatUtils {

    /**
     * 格式化字符串
     * @param str
     * @param length
     * @return
     */
    public static String formatStr(String str, int length) {
        if (str == null) {
            str = "";
        }
        int strLen = str.getBytes().length;
        if (strLen == length) {
            return str;
        } else if (strLen < length) {
            int temp = length - strLen;
            String tem = "";
            for (int i = 0; i < temp; i++) {
                tem = tem + " ";
            }
            return str + tem;
        } else {
            return str.substring(0, length);
        }
    }

    /**
     * 格式化byte[]
     * @param bytes
     * @param length
     * @return
     */
    public static byte[] formatBytes(byte[] bytes, int length) {
        int bytesLen = bytes.length;
        if (bytesLen == length) {
            return bytes;
        } else{
            byte[] newBytes = new byte[length];
            byte[] tem = " ".getBytes();
            if (bytesLen < length){
                System.arraycopy(bytes, 0, newBytes, 0, bytesLen);
                for (int i = bytesLen; i < length;i++){
                    newBytes[i] = tem[0];
                }
            }else{
                System.arraycopy(bytes, 0, newBytes, 0, length);
            }
            return newBytes;
        }
    }

    /**
     * 将字符串加工成COBOL对应的的数字型
     * @param fmt 格式化的初始数据
     * @param str 要处理的字符串
     * @return 处理后的字符串
     */
    public static String formatDecimal(String fmt, String str){
        //处理序号的值，使其00000 -> 00001
        int fmtLength = fmt.length();
        int strLength = str.length();
        StringBuilder sb = new StringBuilder(fmt);
        sb.replace(fmtLength - strLength,fmtLength + 1, str);
        return sb.toString();
    }
}
