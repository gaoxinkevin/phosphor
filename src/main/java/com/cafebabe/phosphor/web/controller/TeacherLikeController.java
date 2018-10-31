package com.cafebabe.phosphor.web.controller;

import com.cafebabe.phosphor.model.entity.Teacher;
import com.cafebabe.phosphor.service.serviceimpl.TeacherLikeServiceImpl;
import com.cafebabe.phosphor.util.JsonResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author kevingx2016@gmail.com
 * <p>
 * class_name: TeacherLikeController
 * <p>
 * create_date: 2018/10/17
 * <p>
 * create_time: 16:43
 * <p>
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

    /**
     * 为指定教师点赞
     *
     * @param teacher 教师信息
     * @return 受影响行数
     */
    @RequestMapping("teacherLikeAdd")
    @ResponseBody
    public JsonResponse teacherLikeAdd(@RequestBody Teacher teacher) {
        return new JsonResponse(200, "success", teacherLikeService.updateTeacherLikeCountAdd(teacher.getTeacherId()));
    }

    /**
     * 根据教师ID获取该教师点赞数
     *
     * @param teacherId 教师ID
     * @return 受影响行数
     */
    @RequestMapping("getTeacherLikeCount/{teacherId}")
    @ResponseBody
    public JsonResponse getTeacherLikeCount(@PathVariable Integer teacherId) {
        return new JsonResponse(200, "success", teacherLikeService.getTeacherLikeCount(teacherId));
    }
}
