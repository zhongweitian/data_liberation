package com.zwt.data_liberation.util;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author WT ZHONG
 * @version 1.0
 * @date 2020/10/25 21:46
 * 数据转换工具
 */
public class DataUtils {
    /**
     * 防止实例化
     */
    private DataUtils() {
    }

    public static String getStringValue(List<Object> list, int subscript){
        return (String) list.get(subscript);
    }

    public static byte[] getByteArrayValue(List<Object> list, int subscript){
        return ((String)list.get(subscript)).getBytes();
    }

    public static BigDecimal getBigDecimalValue(List<Object> list, int subscript){
        return new BigDecimal((String) list.get(subscript));
    }
}
