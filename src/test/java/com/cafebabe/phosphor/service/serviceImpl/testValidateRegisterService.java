package com.cafebabe.phosphor.service.serviceImpl;


import com.cafebabe.phosphor.dao.UserLoginDAO;
import com.cafebabe.phosphor.dao.ValidateRegisterDAO;

import com.cafebabe.phosphor.model.entity.ValidateRegister;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.UUID;

public class testValidateRegisterService {
    BeanFactory beanFactory = new ClassPathXmlApplicationContext("config/applicationContext.xml");


    ValidateRegisterDAO validateRegisterDAO = (ValidateRegisterDAO) beanFactory.getBean("validateRegisterDAO");
    UserLoginDAO userLoginDAO = (UserLoginDAO) beanFactory.getBean("userLoginDAO");

    @Test
    public void testVRS(){
        ValidateRegister validateRegister = new ValidateRegister();
        validateRegister.setParentName("1");
        validateRegister.setParentPassword("1");
        validateRegister.setParentPhone("1");
        validateRegister.setParentToken(UUID.randomUUID().toString());
        validateRegister.setParentTokenTime(new Date());
        validateRegister.setParentEmail("1");
        System.out.print(validateRegisterDAO.insertParentValidateRegisterDAO(validateRegister));
    }

    @Test
    public void testA(){
        System.out.println(userLoginDAO.getUserLoginDao("13913515478"));
    }
}
