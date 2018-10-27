package com.cafebabe.phosphor.dao;

import com.cafebabe.phosphor.model.dto.ChildrenInfoDto;
import com.cafebabe.phosphor.model.entity.Child;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: ChildDAO
 *
 * create_date: 2018/9/26
 *
 * create_time: 16:22
 *
 * description: 孩子信息
 *
 * ChildDAO继承基类
 **/

public interface ChildDAO extends MyBatisBaseDao<Child, Integer> {

    /**
     * 查询当前登录的用户，的所有孩子信息
     * @param parentId 当前用户的id
     * @return 当前用户的所有孩子信息
     */
    List<ChildrenInfoDto> getChildInfoDao(@Param("parentId")Integer parentId);

    /**
     * 向数据库插入
     * @param child 孩子信息
     * @return 受影响的行数
     */
    Integer insertChild(Child child);

    /**
     * 根据编号获取孩子姓名
     * @param childId 孩子编号
     * @return 孩子姓名
     */
    String getChildNameById(Integer childId);
}