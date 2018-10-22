package com.cafebabe.phosphor.web.controller;

import com.cafebabe.phosphor.model.entity.Teacher;
import com.cafebabe.phosphor.service.TeacherLikeService;
import com.cafebabe.phosphor.service.serviceimpl.TeacherLikeServiceImpl;
import com.cafebabe.phosphor.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author kevingx2016@gmail.com
 *
 * class_name: TeacherLikeController
 *
 * create_date: 2018/10/17
 *
 * create_time: 16:43
 *
 * description: 教师点赞的业务控制层
 **/
@Controller
@CrossOrigin
@RequestMapping("/teacherLike")
public class TeacherLikeController {

    @Autowired
    private final TeacherLikeServiceImpl teacherLikeService;

    public TeacherLikeController(TeacherLikeServiceImpl teacherLikeService) {
        this.teacherLikeService = teacherLikeService;
    }

    @RequestMapping("teacherLikeAdd")
    @ResponseBody
    public JsonResponse teacherLikeAdd(@RequestBody Teacher teacher){
        return new JsonResponse(200,"success",teacherLikeService.updateTeacherLikeCountAdd(teacher.getTeacherId()));
    }
}
