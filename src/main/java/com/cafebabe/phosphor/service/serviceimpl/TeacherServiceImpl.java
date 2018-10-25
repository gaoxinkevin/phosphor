package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.dao.TeacherDAO;
import com.cafebabe.phosphor.model.dto.TeacherInformationDTO;
import com.cafebabe.phosphor.model.entity.Teacher;
import com.cafebabe.phosphor.service.TeacherService;
import com.cafebabe.phosphor.util.PageModel;
import com.cafebabe.phosphor.util.RedisUtil;

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
    public PageModel<TeacherInformationDTO> getTeacherList(Integer currentPageCode) {
        PageModel<TeacherInformationDTO> pageModel = new PageModel<>();
        pageModel.setPageSize(5);
        pageModel.setCurrentPageCode(currentPageCode);
        pageModel.setStartRecord((currentPageCode - 1) * pageModel.getPageSize());
        pageModel.setTotalRecord(teacherDAO.getTeacherCount());
        pageModel.setTotalPages(pageModel.getTotalRecord() % pageModel.getPageSize() == 0 ?
                pageModel.getTotalRecord() / pageModel.getPageSize() :
                pageModel.getTotalRecord() / pageModel.getPageSize() + 1);
        if(!currentPageCode.equals(pageModel.getTotalPages())){
            if (0 != RedisUtil.getList("getTeacherList" + currentPageCode).size()) {
                pageModel.setModelList(RedisUtil.getList("getTeacherList" + currentPageCode));
            } else {
                RedisUtil.setList("getTeacherList" + currentPageCode, teacherDAO.getTeacherList(pageModel));
                pageModel.setModelList(RedisUtil.getList("getTeacherList" + currentPageCode));
            }
        }else {
            pageModel.setModelList(teacherDAO.getTeacherList(pageModel));
        }

        return pageModel;
    }

    @Override
    public TeacherInformationDTO getTeacherById(Integer teacherId) {
        return teacherDAO.getTeacherById(teacherId);
    }

    @Override
    public List<Teacher> getTeacherByCompanyId(Integer companyId) {
        return teacherDAO.getTeacherByCompanyId(companyId);
    }

}