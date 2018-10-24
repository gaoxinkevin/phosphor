package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.dao.TeacherDAO;
import com.cafebabe.phosphor.model.dto.TeacherInformation;
import com.cafebabe.phosphor.model.entity.Teacher;
import com.cafebabe.phosphor.service.TeacherService;
import com.cafebabe.phosphor.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kevingx2016@gmail.com
 * <p>
 * class_name: TeacherServiceImpl
 * <p>
 * create_date: 2018/10/17
 * <p>
 * create_time: 09:48
 * <p>
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
    public PageModel<TeacherInformation> getTeacherList(Integer currentPageCode) {
        PageModel<TeacherInformation> pageModel = new PageModel<>();
        pageModel.setPageSize(5);
        pageModel.setCurrentPageCode(currentPageCode);
        pageModel.setStartRecord((currentPageCode - 1) * pageModel.getPageSize());
        pageModel.setTotalRecord(teacherDAO.getTeacherCount());
        pageModel.setTotalPages(pageModel.getTotalRecord() % pageModel.getPageSize() == 0 ? pageModel.getTotalRecord() / pageModel.getPageSize() : pageModel.getTotalRecord() / pageModel.getPageSize() + 1);
        pageModel.setModelList(teacherDAO.getTeacherList(pageModel));
        return pageModel;
    }

    @Override
    public TeacherInformation getTeacherById(Integer teacherId) {
        return teacherDAO.getTeacherById(teacherId);
    }

    @Override
    public List<Teacher> getTeacherByCompanyId(Integer companyId) {
        return teacherDAO.getTeacherByCompanyId(companyId);
    }

}