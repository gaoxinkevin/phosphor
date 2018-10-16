package com.cafebabe.phosphor.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: LoginAnnotation
 *
 * create_date: 2018/10/5
 *
 * create_time: 11:47
 *
 * description: 用户登录拦截器
 **/

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginAnnotation {

}
