package com.example.demo.aop;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.LogInfo;
import com.learn.example.mapper.LogInfoMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * @author pc
 */
@Aspect
@Component
public class MyAspect {

    @Resource
    LogInfoMapper logInfoMapper;


    @Pointcut("execution(public * com.example.demo.*.*.save(*))")
    private void saveAspect() {

    }

    @After("saveAspect()")
    public void doAfterSave(JoinPoint joinPoint) {
        Object[] objects = joinPoint.getArgs();
        JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(objects[0]));
        String username = (String) jsonObject.get("username");

        LogInfo logInfo = new LogInfo();
        logInfo.setId(UUID.randomUUID().toString());
        logInfo.setCreateTime(new Date().toString());
        logInfo.setOperation(username + "执行了保存操作");
        logInfoMapper.insert(logInfo);

        System.out.println("执行了保存后的aop操作" + joinPoint + jsonObject);
    }

    @AfterReturning("execution(* com.example.demo.service.business.HelloService.*(..))")
    public void log() {
        System.out.println("日志出发");
    }


    @Before(value = "execution(* com.example.demo.service.business.HelloService.*(..))")
    public void deBefore() {
        System.out.println("aop的doBefore触发了");
    }

}
