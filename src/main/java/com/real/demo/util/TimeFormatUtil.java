package com.real.demo.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName TimeFormatUtil
 * @Description: 时间格式转换工具类
 * @Author Smile
 * @Date 2021/1/12
 * @Version V1.0
 **/
public class TimeFormatUtil {

    /**
     * specialString to LocalDataTime
     *
     * @param time   时间字符串
     * @param format 时间想要转换的格式
     * @return 返回时间
     */
    public static LocalDateTime parseStringTimeToLocalDateTime(String time, String format) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(time, dateTimeFormatter);
    }


    /**
     * LocalDataTime to specialString
     *
     * @param time   时间
     * @param format 格式
     * @return 返回时间串
     */
    public static String parseStringTime(LocalDateTime time, String format) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        return dateTimeFormatter.format(time);
    }

}
