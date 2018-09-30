package com.cafebabe.phosphor.service;

import com.cafebabe.phosphor.dao.ParentDAO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: ParentService
 *
 * create_date: 2018/9/27
 *
 * create_time: 15:23
 *
 * description: 家长Service
 **/

public interface ParentService {

    Integer insertParentService(String parentMail);
}
