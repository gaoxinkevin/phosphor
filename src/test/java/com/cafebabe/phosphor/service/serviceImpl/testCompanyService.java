package com.cafebabe.phosphor.service.serviceImpl;

import com.cafebabe.phosphor.dao.CompanyDAO;
import com.cafebabe.phosphor.model.entity.Company;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class testCompanyService {
    BeanFactory beanFactory = new ClassPathXmlApplicationContext("config/applicationContext.xml");
    CompanyDAO companyDAO = (CompanyDAO) beanFactory.getBean("companyDAO");
    @Test
    public void testGetCompanyListAll(){
        List<Company> list = companyDAO.getCompanyListAll();
        list.forEach(System.out::println);
    }
}
