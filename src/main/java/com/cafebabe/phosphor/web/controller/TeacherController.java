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
 * <p>
 * class_name: TeacherController
 * <p>
 * create_date: 2018/10/17
 * <p>
 * create_time: 10:16
 * <p>
 * description: 教师的业务控制层
 **/

@Controller
@CrossOrigin
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private final TeacherServiceImpl teacherService;

    public TeacherController(TeacherServiceImpl teacherService) {
        this.teacherService = teacherService;
    }

    /**
     * 根据页码获取当前页教师列表
     *
     * @param currentPageCode 当前页
     * @return 含有教师列表的Json数据
     */
    @RequestMapping("getTeacherList/{currentPageCode}")
    @ResponseBody
    public JsonResponse getTeacherList(@PathVariable Integer currentPageCode) {
        return new JsonResponse(200, "success", teacherService.getTeacherList(currentPageCode));
    }

    /**
     * 根据教师ID获取指定教师信息
     *
     * @param teacherId 教师ID
     * @return 含有指定教师信息的Json数据
     */
    @RequestMapping("getTeacherById/{teacherId}")
    @ResponseBody
    public JsonResponse getTeacherById(@PathVariable Integer teacherId) {
        return new JsonResponse(200, "success", teacherService.getTeacherById(teacherId));
    }

    /**
     * 根据公司ID获取该公司所有教师
     *
     * @param company 公司信息
     * @return 含有符合条件的教师信息的Json数据
     */
    @RequestMapping("getTeacherByCompanyId")
    @ResponseBody
    public JsonResponse getTeacherByCompanyId(@RequestBody Company company) {
        return new JsonResponse(200, "success", teacherService.getTeacherByCompanyId(company.getCompanyId()));
    }
}
