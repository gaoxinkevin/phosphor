package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.dao.ChildDAO;
import com.cafebabe.phosphor.model.entity.Child;
import com.cafebabe.phosphor.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: ChildServiceImpl
 *
 * create_date: 2018/9/26
 *
 * create_time: 16:27
 *
 * description: ChildeService的实现类
 **/

@Service
public class ChildServiceImpl implements ChildService {

    @Autowired
    private final ChildDAO childDAO;

    public ChildServiceImpl(ChildDAO childDAO) {
        this.childDAO = childDAO;
    }


    @Override
    public List<Child> getChildService() {
        return childDAO.getChildDao();
    }
}
