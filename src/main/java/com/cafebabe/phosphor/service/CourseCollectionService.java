package com.cafebabe.phosphor.service;

import com.cafebabe.phosphor.model.dto.Page;
import com.cafebabe.phosphor.model.entity.CourseCollection;

/**
 *
 * @author weijincong@outlook.com
 *
 * class_name: CourseCollectionService
 *
 * create_date: 2018/10/25
 *
 * create_time: 10:06
 *
 * description: 课程收藏信息处理
 **/
public interface CourseCollectionService {
    /**
     *
     * @param pageIndex 页数
     * @param pageSize 每页数
     * @param parentId 用户Id
     * @return 课程List
     */
    Page getAllCourseCollection(Integer pageIndex, Integer pageSize,Integer parentId);
    /**
     * 添加收藏
     * @param courseCollection 收藏信息
     * @return 受影响行数
     */
    Integer insertCollection(CourseCollection courseCollection);

    /**
     * 删除收藏
     * @param collectionId 收藏Id
     * @return 受影响行数
     */
    Integer deleteCollection(Integer collectionId);
}
