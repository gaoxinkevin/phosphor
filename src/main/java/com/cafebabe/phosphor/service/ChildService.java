package com.cafebabe.phosphor.service;

import com.cafebabe.phosphor.model.dto.ChildrenInfoDto;
import com.cafebabe.phosphor.model.entity.Child;

import java.util.List;

/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: ChildService
 *
 * create_date: 2018/9/26
 *
 * create_time: 16:25
 *
 * description: 孩子表的数据处理
 **/

public interface ChildService {
    /**
     * 用户孩子信息
     * @param parentId 用户ID
     * @return 孩子信息
     */
    List<ChildrenInfoDto> getChildInfo(Integer parentId);
}
