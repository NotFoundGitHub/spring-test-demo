package com.example.spring.test.demo.log;

import com.alibaba.fastjson.JSON;
import com.example.spring.test.demo.dto.LogDto;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * @author zhao
 * @version 1.0
 * @date 2020/6/5 16:03
 */

@Aspect
@Component
@Slf4j
public class LogAspect {

    private static ThreadLocal<ArrayList<LogDto>> logListThread = new ThreadLocal<>();
    private static ThreadLocal<Integer> countThread = new ThreadLocal<>();


    @Pointcut("execution(public * com.example.spring.test.demo..*.*(..))")
    public void webLog(){}

    /**
     * 前置通知：在连接点之前执行的通知
     * @param joinPoint
     * @throws Throwable
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        // 通过这获取到方法的所有参数名称的字符串数组
        String[] parameterNames = methodSignature.getParameterNames();
        Class[] parameterTypeNames = methodSignature.getParameterTypes();
        // 接收到请求，记录请求内容
        log.info("joinPoint:{}",JSON.toJSONString(parameterNames));
        log.info("joinPoint:{}",JSON.toJSONString(parameterTypeNames));
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        LogDto logDto = new LogDto();
        logDto.setRemoteIp(request.getRemoteAddr());
        logDto.setMethods(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logDto.setArgs(Arrays.toString(joinPoint.getArgs()));
        if(logDto.getStartTime()==null){
            logDto.setStartTime(System.currentTimeMillis());
            logDto.setOrder(1);
        }
        ArrayList list =  logListThread.get();
        if(CollectionUtils.isEmpty(list)){
            ArrayList arr = new ArrayList();
            arr.add(logDto);
            list=arr;
        }else{
            logDto.setOrder(list.size() + 1);
            list.add(logDto);
        }


        logListThread.set(list);

        Integer count = countThread.get();
        if(count == null){
            count = 1;
        }else{
            count++;
        }
        log.info("before{}....",count);

        countThread.set(count);
    }


    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        ArrayList<LogDto> list = logListThread.get();
        Integer count = countThread.get();
        LogDto logDto = list.get(count-1);
        logDto.setEndTime(System.currentTimeMillis());

        count--;
        countThread.set(count);
        logListThread.set(list);
        log.info("after:{}....",count);
    }



    @Pointcut("execution(public * com.example.spring.test.demo.controller.*.*(..))")
    public void webLogDao(){}


    @AfterReturning(returning = "ret",pointcut = "webLogDao()")
    public void doAfterReturningDao(Object ret) throws Throwable {
        log.info("response : " + ret);
        // 处理完请求，返回内容
        log.info("finish:{}",JSON.toJSONString(logListThread.get()));
    }
}
