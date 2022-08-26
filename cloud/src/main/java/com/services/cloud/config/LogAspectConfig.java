package com.services.cloud.config;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.PropertyPreFilters;
import com.services.core.util.UuidUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;

/**
 * 日志配置
 */
@Aspect
@Component
public class LogAspectConfig
{
    /**
     * 排除敏感或太长的字段
     */
    private final static String[] EXCLUDE_PROPERTIES = {"bytes"};
    private final static Logger logger = LoggerFactory.getLogger(LogAspectConfig.class);
    private long startTime;

    @Pointcut("execution(public * com.services..*Controller.*(..))")
    public void controllerPointcut(){}

    @Pointcut("execution(* com.services..ControllerExceptionHandler.*ValidatorHandler(..))")
    public void validatorExceptionHandlerPointcut(){}

    @Pointcut("controllerPointcut() || validatorExceptionHandlerPointcut()")
    public void requestPointCut(){}

    @Before("requestPointCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable
    {
        startTime = System.currentTimeMillis();
        // 日志编号
        MDC.put("UUID", UuidUtil.getShortUuid());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        // 获取业务名称
        Class clazz = signature.getDeclaringType();
        try
        {
            Field field = clazz.getField("BUSINESS_NAME");
            if (!StringUtils.isEmpty(field))
            {
                String businessName  = (String) field.get(clazz);
                logger.info("------------- 【{}】 -------------", businessName);
            }
        } catch (NoSuchFieldException | SecurityException e)
        {
            logger.warn("未获取到业务名称");
        }
        // 打印请求信息
        logger.info("请求地址: {} {}", request.getRequestURL().toString(), request.getMethod());
        logger.info("类名方法: {}.{}", signature.getDeclaringTypeName(), name);
        logger.info("远程地址: {}", request.getRemoteAddr());
        // 打印请求参数
        Object[] args = joinPoint.getArgs();
        Object[] arguments = new Object[args.length];
        for (int i = 0; i < args.length; i++)
        {
            if (args[i] instanceof ServletRequest
                    || args[i] instanceof ServletResponse
                    || args[i] instanceof MultipartFile
                    || args[i] instanceof Exception
            )
            {
                continue;
            }
            arguments[i] = args[i];
        }
        PropertyPreFilters filters = new PropertyPreFilters();
        PropertyPreFilters.MySimplePropertyPreFilter excludefilter = filters.addFilter();
        excludefilter.addExcludes(EXCLUDE_PROPERTIES);
        logger.info("请求参数: {}", JSONObject.toJSONString(arguments, excludefilter));
    }

    @Around("requestPointCut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {
        Object result = proceedingJoinPoint.proceed();
        PropertyPreFilters propertyPreFilters = new PropertyPreFilters();
        PropertyPreFilters.MySimplePropertyPreFilter mySimplePropertyPreFilter = propertyPreFilters.addFilter();
        mySimplePropertyPreFilter.addExcludes(EXCLUDE_PROPERTIES);
        logger.info("返回结果: {}", JSONObject.toJSONString(result, mySimplePropertyPreFilter));
        logger.info("------------- 耗时：{} ms -------------", System.currentTimeMillis() - startTime);
        return result;
    }

}