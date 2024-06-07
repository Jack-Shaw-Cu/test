package com.test1.config;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author XT
 * @Title: LogAspectController
 * @Date: 2024/5/11 17:08
 * @description: 日志切面配置类
 */
@Aspect
@Slf4j
@Component
public class LogAspectController {


    /**
     * 申明切点
     */
    @Pointcut("execution(public * com.test1.controller..*.*(..))")
    private void controllerAspect() {

    }

    /**
     * 执行方法前打印
     * @param joinPoint 切点
     */
    @Before(value = "controllerAspect()")
    public void methodBefore(JoinPoint joinPoint){
        Map<String,String[]> map;
        ServletRequestAttributes servletRequestAttributes =  (ServletRequestAttributes) RequestContextHolder
               .getRequestAttributes();
        if(servletRequestAttributes != null){
            HttpServletRequest request = servletRequestAttributes.getRequest();
            map = request.getParameterMap();
            if(map != null && !map.isEmpty()){
                log.info("method: " + joinPoint
                        + ",url: " + request.getRequestURI()
                        + ",requestMethod: " + request.getMethod()
                        + ",parameter: " + JSONObject.toJSONString(request.getParameterMap()));
            }else {
                Object[] args = joinPoint.getArgs();
                if (null != args && args.length > 0){
                    log.info("method: " + joinPoint
                            + ",url: " + request.getRequestURI()
                            + ",requestMethod: " + request.getMethod()
                            + ",parameter: " + StringUtils.join(args));
                }
            }
        }

    }


}
