package com.learn.example.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author: 陈仕亮
 * @Date: 17:14 2020/9/17
 * @Description:
 */

@Component
public class GetSpringUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;


    /**
     * 获取applicationContext
     *
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (GetSpringUtils.applicationContext == null) {
            GetSpringUtils.applicationContext = applicationContext;
        }
    }


    /**
     * 通过name获取bean
     *
     * @param name
     * @return
     */
    public static Object getBean(String name) {

        return getApplicationContext().getBean(name);
    }

    /**
     * 通过class获取bean
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {

        return getApplicationContext().getBean(clazz);
    }


    /**
     * 通过name，以及claszz返回指定的bean
     *
     * @param name
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name, Class<T> clazz) {

        return getApplicationContext().getBean(name, clazz);
    }


    public static ApplicationContext getContext() {
        return applicationContext;
    }

}
