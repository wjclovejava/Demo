package com.example.wjc.ssecurity1215.excel_import;

import lombok.Data;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2018/12/31 16:44
 */
@Data
public class ExcelHeader implements Comparable<ExcelHeader> {

    /**
     * excel的标题名称
     */
    private String title;
    /**
     * 每一个标题的顺序
     */
    private int order;
    /**
     * 变量名
     */
    private String filed;

    @Override
    public int compareTo(ExcelHeader o) {
        return order - o.order;
    }

    public ExcelHeader(String title, int order, String filed) {
        super();
        this.title = title;
        this.order = order;
        this.filed = filed;
    }

}
