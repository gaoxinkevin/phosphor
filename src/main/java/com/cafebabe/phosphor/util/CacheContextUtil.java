package com.cafebabe.phosphor.util;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: CacheContextUtil
 *
 * create_date: 2018/10/19
 *
 * create_time: 13:55
 *
 * description:
 **/

@SuppressWarnings("static-access")
@Component
public class CacheContextUtil implements ApplicationContextAware {

    private static ApplicationContext commonApplicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        commonApplicationContext = applicationContext;
    }

    @SuppressWarnings("unused")
    public static Object getBean(String beanId) {
        return commonApplicationContext.getBean(beanId);
    }

    static <T> T getBean(String beanId, Class<T> clazz) {
        return commonApplicationContext.getBean(beanId, clazz);
    }


}
