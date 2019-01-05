package com.example.wjc.ssecurity1215.excel_import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2018/12/31 16:30
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelField {
    /**
     * 属性的标题名称
     */
    String title();

    /**
     * 在excel的顺
     */
    int colum();

    Class claz();

    int maxLength() default 50;
}
