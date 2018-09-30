package com.cafebabe.phosphor.service.serviceImpl;


import com.cafebabe.phosphor.dao.ParentDAO;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class textParentService {

    @Autowired
    private final ParentDAO parentDAO;

    public textParentService(ParentDAO parentDAO) {
        this.parentDAO = parentDAO;
    }

    @Test
    public void testRegister(){
        Integer i =parentDAO.insertParentDao("sue@ooo.com");
    }
}
