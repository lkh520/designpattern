package com.lkh.mqclient.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author ABin
 * @ClassName com.com.member.member.common.util
 * @Description Application上下文对象工具类
 * @Date 2018/4/2 18:23
 * @Version 1.0
 */
@Component
public class ApplicationContextUtil implements ApplicationContextAware {
    /**
     * 上下文对象实例
     */
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     *
     * @Titel 获取applicationContext
     * @Description 获取applicationContext
     * @Author ABin
     * @DateTime 2018/4/3 19:07
     * @param
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     *
     * @Titel 通过name获取 Bean.
     * @Description 通过name获取 Bean.
     * @Author ABin
     * @DateTime 2018/4/3 19:07
     * @param   name Bean名称
     * @return Object
     */
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }

    /**
     *
     * @Titel 通过class获取Bean.
     * @Description
     * @Author ABin
     * @DateTime 2018/4/3 19:07
     * @param clazz 类
     * @return Bean
     */
    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

    /**
     *
     * @Titel 通过name,以及Clazz返回指定的Bean
     * @Description
     * @Author ABin
     * @DateTime 2018/4/3 19:09
     * @param   name Bean名称 clazz 类
     * @return
     */
    public static <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name, clazz);
    }

    /**
     * @Author A Jun
     * @Description
     * @DateTime 2018/4/16 12:59
     * @param
     * @return
     */
    public static <T> T getBeanByClass(String name,Class<T> clazz){
        String className = clazz.getSimpleName();
        return getApplicationContext().getBean(className.concat(".").concat(name), clazz);
    }

}
