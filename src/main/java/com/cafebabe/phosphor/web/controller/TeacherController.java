package com.cafebabe.phosphor.web.controller;

import com.cafebabe.phosphor.dao.TeacherDAO;
import com.cafebabe.phosphor.model.entity.Company;
import com.cafebabe.phosphor.model.entity.Teacher;
import com.cafebabe.phosphor.service.TeacherService;
import com.cafebabe.phosphor.service.serviceimpl.TeacherServiceImpl;
import com.cafebabe.phosphor.util.JsonResponse;
import com.cafebabe.phosphor.util.PageModel;
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

    @RequestMapping("getTeacherList/{currentPageCode}")
    @ResponseBody
    public JsonResponse getTeacherList(@PathVariable Integer currentPageCode) {
        return new JsonResponse(200,"success",teacherService.getTeacherList(currentPageCode));
    }

    @RequestMapping("getTeacherById/{teacherId}")
    @ResponseBody
    public JsonResponse getTeacherById(@PathVariable Integer teacherId){
        return new JsonResponse(200,"success",teacherService.getTeacherById(teacherId));
    }

    @RequestMapping("getTeacherByCompanyId")
    @ResponseBody
    public JsonResponse getTeacherByCompanyId(@RequestBody Company company){
        return new JsonResponse(200,"success",teacherService.getTeacherByCompanyId(company.getCompanyId()));
    }
}
