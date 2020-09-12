package com.example.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期格式化工具类
 */
public class DateUtil {

    /**
     * 格式化日期的方法
     * @param date
     */
    public static String DateChange(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年 MM月 dd日 HH时 mm分 ss秒");
        return sdf.format( date );
    }
}
