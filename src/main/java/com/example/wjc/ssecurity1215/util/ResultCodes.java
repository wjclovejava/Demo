package com.example.wjc.ssecurity1215.util;


public enum ResultCodes {
    SUCCESS(0, "成功"),
    SYS_EXCEPTION(1, "系统异常"),
    PARAMETER_EMPTY(2,"参数为空"),
    ADD_FAIL(3,"新增失败"),
    UPDATE_FAIL(4, "修改失败"),
    DELETE_FAIL(5, "删除失败"),
    PARAMETER_INVALID(6,"参数错误"),
    DATA_EXISTS(7,"数据已存在"),
    UNDEFIND_ERROR(8, "未知错误"),
    DATA_ERROR(9, "数据错误"),
    DATA_NOT_EXIST(10,"该数据不存在"),














    XXXXX(-10000000, "异常");


    private int code;
    private String message;

    ResultCodes(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
