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

    /**
     * 创建用户 测试用
     * @param parentMail
     * @return
     */
    Integer insertParentService(String parentMail);

    /**
     * 获取用户所对应的用户头像
     * @param parentPhone
     * @return
     */
    String  getParentImgUrlService(String parentPhone);

    String getParentByParentPhoneService(String parentPhone);
}
