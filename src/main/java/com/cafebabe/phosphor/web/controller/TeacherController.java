package com.cafebabe.phosphor.web.controller;

import com.cafebabe.phosphor.dao.TeacherDAO;
import com.cafebabe.phosphor.model.entity.Company;
import com.cafebabe.phosphor.model.entity.Teacher;
import com.cafebabe.phosphor.service.TeacherService;
import com.cafebabe.phosphor.service.serviceimpl.TeacherServiceImpl;
import com.cafebabe.phosphor.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kevingx2016@gmail.com
 *
 * class_name: TeacherController
 *
 * create_date: 2018/10/17
 *
 * create_time: 10:16
 *
 * description: 教师的业务控制层
 **/

@Controller
@CrossOrigin
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private final TeacherServiceImpl teacherService;

    public TeacherController(TeacherServiceImpl teacherService) {
        this.teacherService=teacherService;
    }

    @RequestMapping("getTeacherList")
    @ResponseBody
    public JsonResponse getTeacherList() {
        List<Teacher> teacherList = teacherService.getTeacherList();
        return new JsonResponse(200,"success",teacherList);
    }

    @RequestMapping("getTeacherById")
    @ResponseBody
    public JsonResponse getTeacherById(@RequestBody Teacher teacher){
        return new JsonResponse(200,"success",teacherService.getTeacherById(teacher.getTeacherId()));
    }

    @RequestMapping("getTeacherByCompanyId")
    @ResponseBody
    public JsonResponse getTeacherByCompanyId(@RequestBody Company company){
        return new JsonResponse(200,"success",teacherService.getTeacherByCompanyId(company.getCompanyId()));
    }
}
