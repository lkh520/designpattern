package com.lkh.mqclient.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Description Application上下文对象工具类
 */
@Component
public class ApplicationContextUtil implements ApplicationContextAware {
    
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextUtil.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }
   
    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }
   
    public static <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name, clazz);
    }
    
    public static <T> T getBeanByClass(String name,Class<T> clazz){
        String className = clazz.getSimpleName();
        return getApplicationContext().getBean(className.concat(".").concat(name), clazz);
    }

}
