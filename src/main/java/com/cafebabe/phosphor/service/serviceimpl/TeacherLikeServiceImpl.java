package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.dao.TeacherLikeDAO;
import com.cafebabe.phosphor.service.TeacherLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kevingx2016@gmail.com
 * <p>
 * class_name: TeacherLikeServiceImpl
 * <p>
 * create_date: 2018/10/17
 * <p>
 * create_time: 16:40
 * <p>
 * description: 教师点赞Service层的实现类
 **/
@Service
public class TeacherLikeServiceImpl implements TeacherLikeService {
    @Autowired
    private final TeacherLikeDAO teacherLikeDAO;

    public TeacherLikeServiceImpl(TeacherLikeDAO teacherLikeDAO) {
        this.teacherLikeDAO = teacherLikeDAO;
    }

    @Override
    public int updateTeacherLikeCountAdd(Integer teacherId) {
        return teacherLikeDAO.updateTeacherLikeCountAdd(teacherId);
    }
}
