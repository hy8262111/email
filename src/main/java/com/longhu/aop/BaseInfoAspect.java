package com.longhu.aop;

/**
 * @author: houyong
 * @description:
 * @create: 2019-04-12 17:15
 */
/*@Aspect
@Repository
public class BaseInfoAspect {
    @Pointcut("execution(public * com.longhu.repository.*.save*(..)) && args(BaseDomain,..)")
    public void addPointcut() {
    }

    @Before("addPointcut()")
    public void appendCreateInfo(BaseDomain baseDomain) throws Exception {
        *//*if (baseDomain instanceof Session || baseDomain instanceof SystemLog) {
            return;
        }
        Session session = ThreadVariable.getSession();
        if (session == null || session.getUserName() == null) {
            logger.error("系统尝试在无登陆的情况下添加[{}]对象", baseDomain.getClass()
                    .getName());
            throw new Exception("Session不存在，系统不能正常工作!");
        }
        baseDomain.setCreateDate(session.getAccessTime());
        baseDomain.setCreateUser(session.getUserName());*//*
        baseDomain.setModifyTime(new Date());
    }
}*/
