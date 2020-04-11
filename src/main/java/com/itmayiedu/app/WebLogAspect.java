package com.itmayiedu.app;

import com.itmayiedu.controller.IndexController;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Component
@Aspect
public class WebLogAspect {
    private static Logger logger = Logger.getLogger(IndexController.class);

    @Pointcut("execution(public * com.itmayiedu.controller..*.*(..))")
    public void webLog(){

    }

    @Before("webLog()")
    public void deBefore(JoinPoint joinPoint)throws Throwable{
        //接收到请求,记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //记录下请求内容
        logger.info("URL : " + request.getRequestURI().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        Enumeration<String> enu = request.getParameterNames();
        while(enu.hasMoreElements()){
            String name = enu.nextElement();
            logger.info("name:" + name + ",value:" +request.getParameter(name));
        }
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
    }
}
