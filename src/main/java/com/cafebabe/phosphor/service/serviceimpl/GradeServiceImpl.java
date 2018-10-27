package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.dao.GradeDAO;
import com.cafebabe.phosphor.model.dto.GradeInfo;
import com.cafebabe.phosphor.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *
 * @author weijincong@outlook.com
 *
 * class_name: GradeServiceImpl
 *
 * create_date: 2018/10/25
 *
 * create_time: 9:14
 *
 * description: 成绩信息实现类
 **/
public class GradeServiceImpl implements GradeService {

    @Autowired
    private final GradeDAO gradeDAO;

    public GradeServiceImpl(GradeDAO gradeDAO) {
        this.gradeDAO = gradeDAO;
    }

    @Override
    public List<GradeInfo> getGradeByChild(Integer childId) {
        return gradeDAO.getGradeByChild(childId);
    }
}
