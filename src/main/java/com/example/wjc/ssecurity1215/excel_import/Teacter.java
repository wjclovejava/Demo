package com.example.wjc.ssecurity1215.excel_import;

import lombok.Data;

import java.util.Date;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2019/1/4 10:55
 */
@Data
public class Teacter {

    @ExcelField(title="时间",colum=0,claz = Teacter.class)
    private Date date;

    @ExcelField(title="教师工号",colum=2,claz = Teacter.class)
    private Integer teacherNo;

    @ExcelField(title="科目",colum=3,claz = Teacter.class)
    private String subject;

    @ExcelField(title="年龄",colum=5,claz = Teacter.class)
    private Integer age;

    @ExcelField(title="手机号",colum=7,claz = Teacter.class)
    private String phoneNumber;

}