package com.cafebabe.phosphor.dao;

import com.cafebabe.phosphor.model.entity.Group;
import org.apache.ibatis.annotations.Param;
import java.math.BigDecimal;
import java.util.List;

/**
 * GroupDAO继承基类
 */
public interface GroupDAO extends MyBatisBaseDao<Group, Integer> {


    /**
     * 添加套餐
     * @return 0=>false | 1=>true
     */
    Integer insertGroup(Group group);

    /**
     * 获取最后插入的套餐id
     * @return 套餐id
     */
    Integer getGroupId();

    /**
     * 修改套餐
     * @return 0=>false | 1=>true
     */
    Integer updateGroup(Group group);

    /**
     * 修改套餐折扣
     * @param groupId 套餐编号
     * @param groupDiscount   套餐折扣
     * @return 0=>false | 1=>true
     */
    Integer updateGroupDiscount(@Param("groupDiscount") BigDecimal groupDiscount, @Param("groupId") Integer groupId);

    /**
     * 修改套餐状态
     * @return 0=>false | 1=>true
     */
    Integer updateGroupStatus(@Param("groupStatus") Integer groupStatus, @Param("groupId") Integer groupId);

    /**
     * 删除套餐
     * @return 0=>false | 1=>true
     */
    Integer removeGroup(Integer id);

    /**
     * 根据套餐的id查询套餐信息
     * @param id 套餐id
     * @return 套餐信息
     */
    Group getGroupById(Integer id);

    /**
     * 获取所有的套餐信息
     * @return group的列表
     */
    List<Group> getGroupListAll();

    /**
     * 获取所有正在进行的套餐
     * @return group的列表
     */
    List<Group> getGroupListAlive();

    /**
     * 根据套餐的折扣查询套餐信息
     * @param discount 套餐折扣
     * @return 套餐信息列表
     */
    List<Group> getGroupListByDiscount(BigDecimal discount);

    /**
     * 根据套餐的折扣范围查询套餐信息
     * @param minDiscount 最小折扣
     * @param maxDiscount 最大折扣
     * @return 套餐信息列表
     */
    List<Group> getGroupListByDiscountScope(@Param("minDiscount") BigDecimal minDiscount, @Param("maxDiscount") BigDecimal maxDiscount);

}