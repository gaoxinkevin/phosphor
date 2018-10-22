package com.cafebabe.phosphor.dao;

import com.cafebabe.phosphor.model.dto.TeacherInformation;
import com.cafebabe.phosphor.model.entity.Teacher;
import com.cafebabe.phosphor.util.PageModel;

import java.util.List;

/**
 * @author kevingx2016@gmail.com
 *
 * class_name: TeacherDAO
 *
 * create_date: 2018/10/17
 *
 * create_time: 09:34
 *
 * description: 教师模块
 **/
public interface TeacherDAO extends MyBatisBaseDao<Teacher, Integer> {

    /**
     * 获取所有在职的教师的信息
     * @param pageModel 分页信息
     * @return 在职的教师信息
     */
    List<TeacherInformation> getTeacherList(PageModel<TeacherInformation> pageModel);

    /**
     * 获取所有在职的教师数量
     * @return 在职的教师数量
     */
    Integer getTeacherCount();

    /**
     * 根据教师ID获取某个老师的信息
     * @param teacherId 教师ID
     * @return 教师信息
     */
    TeacherInformation getTeacherById(Integer teacherId);

    /**
     * 根据公司ID获取属于该公司的所有在职教师
     * @param companyId 公司ID
     * @return 某公司所有在职教师
     */
    List<Teacher> getTeacherByCompanyId(Integer companyId);

}
