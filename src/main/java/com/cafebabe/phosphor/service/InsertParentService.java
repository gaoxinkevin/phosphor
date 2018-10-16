package com.cafebabe.phosphor.service;


import com.cafebabe.phosphor.model.dto.InsertParent;

/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: InsertParentService
 *
 * create_date: 2018/10/12
 *
 * create_time: 15:16
 *
 * description: 插入用户，涉及两张表，需要dto
 **/

public interface InsertParentService {
    /**
     * 插入用户
     * @param insertParent
     * @return
     */
    boolean insertIntoParent(InsertParent insertParent);
}
