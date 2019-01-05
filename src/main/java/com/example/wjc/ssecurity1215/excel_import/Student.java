package com.example.wjc.ssecurity1215.excel_import;

import lombok.Data;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2018/12/31 17:02
 */
@Data
public class Student {

    @ExcelField(title="编号",colum=0,claz = Student.class)
    private Integer id;

    @ExcelField(title="姓名",colum=1,claz = Student.class)
    private String name;

    @ExcelField(title="成绩",colum=3,claz = Student.class)
    private Integer score;

    @ExcelField(title="年龄",colum=4,claz = Student.class)
    private Integer age;

    @ExcelField(title="手机号",colum=5,claz = Student.class)
    private String phoneNumber;

}
