package com.cafebabe.phosphor.service;

import com.cafebabe.phosphor.model.dto.CourseInfo;
import com.cafebabe.phosphor.model.dto.GroupDTO;
import com.cafebabe.phosphor.model.entity.Group;
import java.math.BigDecimal;
import java.util.List;
/**
 *
 * @author thethingyk@gmail.com
 *
 * class_name: GroupService
 *
 * create_date: 2018/10/9
 *
 * create_time: 19:30
 *
 * description: 套餐service层接口
 **/
public interface GroupService {

    /**
     * 添加套餐
     * @param courses 课程ID
     * @param group 套餐
     * @return 0=>false | 1=>true
     */
    Integer insertGroup(Group group,List<Integer> courses);

    /**
     * 添加套餐
     * @param groupDTO 套餐传输对象
     * @return 套餐id
     */
    Integer insertGroupDTO(GroupDTO groupDTO);

    /**
     * 修改套餐
     * @param group 套餐
     * @return 0=>false | 1=>true
     */
    Integer updateGroup(Group group);

    /**
     * 修改套餐折扣
     * @param groupId 套餐编号
     * @param groupDiscount   套餐折扣
     * @return 0=>false | 1=>true
     */
    Integer updateGroupDiscount(BigDecimal groupDiscount, Integer groupId);

    /**
     * 修改套餐状态
     * @return 0=>false | 1=>true
     */
    Integer updateGroupStatus( Integer groupStatus, Integer groupId);

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
     * 根据套餐的id查询套餐信息
     * @param id 套餐id
     * @return 套餐信息
     */
    GroupDTO getGroupDTOById(Integer id);
    /**
     * 获取所有的套餐信息
     * @return group的列表
     */
    List<Group> getGroupListAll();

    /**
     * 根据活动编号获取课程
     * @param  groupId
     * @return
     */
    List<CourseInfo> getCourseListByGroupId(Integer groupId);

    /**
     * 获取所有正在进行的套餐
     * @return group的列表
     */
    List<GroupDTO> getGroupListAlive();

    /**
     * 根据套餐的折扣查询套餐信息
     * @param discount 套餐折扣
     * @return 套餐信息列表
     */
    List<GroupDTO> getGroupListByDiscount(BigDecimal discount);

    /**
     * 根据套餐的折扣范围查询套餐信息
     * @param minDiscount 最小折扣
     * @param maxDiscount 最大折扣
     * @return 套餐信息列表
     */
    List<GroupDTO> getGroupListByDiscountScope( BigDecimal minDiscount, BigDecimal maxDiscount);

    /**
     * 在已有自定义套餐中添加课程
     * @param groupDTO 套餐传输对象
     * @param courseId 课程编号
     * @return 套餐
     */
    GroupDTO addCourseToGroup(GroupDTO groupDTO,Integer courseId);

    /**
     * 在已有自定义套餐中删除课程
     * @param groupDTO 套餐传输对象
     * @param courseId 课程编号
     * @return 套餐
     */
    GroupDTO delCourseFromCourse(GroupDTO groupDTO,Integer courseId);

    /**
     * 获取所有正在进行的套餐
     * @return group的列表
     */
    List<GroupDTO> getGroupListRecommend();


    /**
     * 创建套餐
     * @param courseId 课程编号
     * @return 套餐传输对象
     */
    GroupDTO createGroup(Integer courseId);

    /**
     * 套餐按时间排序
     * @return 套餐列表
     */
    List<GroupDTO> getGroupByTime();

    /**
     * 套餐按价格升序
     * @return 套餐列表
     */
    List<GroupDTO>  getGroupByPriceAsc();

    /**
     * 套餐按价格降序
     * @return 套餐列表
     */
    List<GroupDTO> getGroupByPriceDesc();

}
