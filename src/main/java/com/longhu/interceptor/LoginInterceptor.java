package com.longhu.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: houyong
 * @descririiption: 登陆拦截器
 * @create: 2019-04-09 10:32
 */
public class LoginInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

    /**
     * 进入controller层之前拦截请求
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        /*HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 获取方法上的注解
        RequirePermission requiredPermission = handlerMethod.getMethod().getAnnotation(RequirePermission.class);
        // 如果方法上的注解为空,不需要权限
        if (requiredPermission == null) {
            return true;
        }
        // 如果标记了注解，则判断权限
        String value = requiredPermission.value();
        Set<String> permSet = new HashSet<>();
        permSet.add("addUser");
        permSet.add("delUser");
        if (permSet.contains(value)) {
            return true;
        }
        return false;*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        log.info("--------------处理请求完成后视图渲染之前的处理操作---------------");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        log.info("---------------视图渲染之后的操作-------------------------0");
    }

}
