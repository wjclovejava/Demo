package com.example.wjc.ssecurity1215.util;

import org.apache.commons.lang.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class String2DateUtil {

    private static String parttern = "yyyy-MM-dd HH:mm:ss";

    public static String DAY_START = " 00:00:00";
    public static String DAY_END = " 23:59:59";

    public static Date formatDate(String str,String ss){
        if(StringUtils.isEmpty(str)){
            return null;
        }
        String timeStr = str+ss;
        SimpleDateFormat sdf = new SimpleDateFormat(parttern);
        Date date = null;
        try {
            date = sdf.parse(timeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Timestamp formatTimestap(String str,String ss){
        if(StringUtils.isEmpty(str)){
            return null;
        }
        String timeStr = str+ss;
        Timestamp timestamp = null;
        try {
            timestamp =Timestamp.valueOf(timeStr);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("日期格式必须为yyyy-MM-dd");
        }
        return timestamp;
    }

    public static void main(String[] args){
        System.out.println(String2DateUtil.formatDate("2017-02-16",String2DateUtil.DAY_END));
    }
}
