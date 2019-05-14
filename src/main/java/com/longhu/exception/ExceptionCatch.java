package com.longhu.exception;

import com.google.common.collect.ImmutableMap;
import com.longhu.response.CodeMsg;
import com.longhu.response.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: houyong
 * @descririiption: 捕获异常类
 * @create: 2019-03-13 14:02
 */
@RestControllerAdvice
public class ExceptionCatch {
    /**
     * 系统异常，包括一些可预知得异常和不可预知得，例如springmvc中参数得异常，不可预知得异常统一抛出为99999，服务器异常
     */

    ImmutableMap<Class<? extends Exception>, CodeMsg> EXCEPTIONS;
    static ImmutableMap.Builder<Class<? extends Exception>, CodeMsg> builder = ImmutableMap.builder();

    static {
        builder.put(java.lang.ArithmeticException.class, CodeMsg.ARITHMETIC_EXCEPTION);
    }

    /*@ExceptionHandler
    public Result sysExpCat(Exception e) {
        if (EXCEPTIONS == null) {
            EXCEPTIONS = builder.build();
        }
        CodeMsg codeMsg = EXCEPTIONS.get(e.getClass());
        if (codeMsg != null) {
            return Result.error(codeMsg);
        }
        return Result.error(CodeMsg.systemExp);
    }*/

    /**
     * 程序员自定义抛出得异常捕获
     */
    @ExceptionHandler
    public Result customerCat(CustomerException c) {
        CodeMsg codeMsg = c.getCodeMsg();
        return Result.error(codeMsg);
    }
}
