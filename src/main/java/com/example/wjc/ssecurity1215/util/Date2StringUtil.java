package com.example.wjc.ssecurity1215.util;

import org.apache.commons.lang.time.DateFormatUtils;

import java.sql.Timestamp;
import java.util.Date;

public class Date2StringUtil {

    private static String pattern = "yyyy-MM-dd HH:mm:ss";

    public static String format(Date date){
        return date!=null? DateFormatUtils.format(date,pattern):null;
    }

    public static String format(Timestamp date, String pattern){
        return date!=null?DateFormatUtils.format(date,pattern):null;
    }

    public static String format(Date date ,String pattern){
        return date!=null? DateFormatUtils.format(date,pattern):null;
    }

    public static String format(Timestamp date){
        return date!=null?DateFormatUtils.format(date,pattern):null;
    }
}
