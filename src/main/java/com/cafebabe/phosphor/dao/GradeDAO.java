package com.cafebabe.phosphor.dao;

import com.cafebabe.phosphor.model.dto.GradeInfo;
import com.cafebabe.phosphor.model.entity.Grade;

import java.util.List;

/**
 * GradeDAO继承基类
 */
public interface GradeDAO extends MyBatisBaseDao<Grade, Integer> {

    /**
     * 根据孩子Id查询该孩子所有课程成绩
     * @param childId 孩子Id
     * @return 成绩信息
     */
    List<GradeInfo> getGradeByChild(Integer childId);
}