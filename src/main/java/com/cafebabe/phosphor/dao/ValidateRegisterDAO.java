package com.cafebabe.phosphor.dao;

import com.cafebabe.phosphor.model.entity.ValidateRegister;

/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: ValidateRegisterDAO
 *
 * create_date: 2018/9/28
 *
 * create_time: 15:08
 *
 * description: 验证用户是否可以进行注册
 **/

public interface ValidateRegisterDAO extends MyBatisBaseDao<ValidateRegister, Integer> {

    /**
     * 插入还没有进行确认的用户的信息
     * @param validateRegister
     * @return
     */
    Integer insertParentValidateRegisterDAO(ValidateRegister validateRegister);
}