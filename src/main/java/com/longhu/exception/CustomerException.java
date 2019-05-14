package com.longhu.exception;

import com.longhu.response.CodeMsg;

/**
 * @author: houyong
 * @descririiption: 自定义异常类
 * @create: 2019-03-13 13:59
 */
public class CustomerException extends RuntimeException {
    private CodeMsg codeMsg;

    public CustomerException(CodeMsg codeMsg) {
        this.codeMsg = codeMsg;
    }


    public CodeMsg getCodeMsg() {
        return codeMsg;
    }
}
