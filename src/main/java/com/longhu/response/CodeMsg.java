package com.longhu.response;

public class CodeMsg {
    private int retCode;
    private String message;
    // 按照模块定义CodeMsg
    // 通用异常
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static CodeMsg SERVER_EXCEPTION = new CodeMsg(500100, "服务端异常");
    public static CodeMsg ARITHMETIC_EXCEPTION = new CodeMsg(500101, "算术除零异常");

    // 业务异常
    public static CodeMsg CREATE_FAILED = new CodeMsg(500102, "创建失败");

    public static CodeMsg NOT_FIND_DATA = new CodeMsg(500105, "查找不到对应数据");


    //所有不可预知得异常
    public static CodeMsg systemExp = new CodeMsg(999999, "服务器异常");

    public CodeMsg(int retCode, String message) {
        this.retCode = retCode;
        this.message = message;
    }

    public int getRetCode() {
        return retCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}