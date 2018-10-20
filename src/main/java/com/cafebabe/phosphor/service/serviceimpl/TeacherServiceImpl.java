package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.dao.TeacherDAO;
import com.cafebabe.phosphor.model.entity.Teacher;
import com.cafebabe.phosphor.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kevingx2016@gmail.com
 *
 * class_name: TeacherServiceImpl
 *
 * create_date: 2018/10/17
 *
 * create_time: 09:48
 *
 * description: 教师service层的实现类
 **/

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private final TeacherDAO teacherDAO;

    public TeacherServiceImpl(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    @Override
    public List<Teacher> getTeacherList() {
        return teacherDAO.getTeacherList();
    }

    @Override
    public Teacher getTeacherById(Integer teacherId) {
        return teacherDAO.getTeacherById(teacherId);
    }

    @Override
    public List<Teacher> getTeacherByCompanyId(Integer companyId) {
        return teacherDAO.getTeacherByCompanyId(companyId);
    }

}