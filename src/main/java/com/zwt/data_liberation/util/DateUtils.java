package com.zwt.data_liberation.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author WT ZHONG
 * @version 1.0
 * @date 2020/2/1 20:48
 * 日期工具类
 */
public class DateUtils {

    /**
     * 防止实例化
     */
    private DateUtils() {
    }


    /**
     * 将Date转换成毫秒
     * @param date 日期
     * @return 毫秒
     */
    public static long getMillis(Date date) {
        return date.getTime();
    }

    public static Timestamp getTimestamp(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(new Date());
        return Timestamp.valueOf(time);
    }
}
