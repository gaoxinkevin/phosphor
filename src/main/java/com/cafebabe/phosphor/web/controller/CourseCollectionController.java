package com.cafebabe.phosphor.web.controller;

import com.cafebabe.phosphor.model.dto.Page;
import com.cafebabe.phosphor.service.serviceimpl.CourseCollectionServiceImpl;
import com.cafebabe.phosphor.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author weijincong@outlook.com
 *
 * class_name: CourseCollectionController
 *
 * create_date: 2018/10/25
 *
 * create_time: 10:36
 *
 * description:  课程收藏控制类
 **/

@Controller
@CrossOrigin
@RequestMapping("/courseCollection")
public class CourseCollectionController {

    @Autowired
    private final CourseCollectionServiceImpl courseCollectionService;

    public CourseCollectionController(CourseCollectionServiceImpl courseCollectionService) {
        this.courseCollectionService = courseCollectionService;
    }

    @ResponseBody
    @RequestMapping("/getCourseCollectionList/{parentId}")
    public JsonResponse getCourseList(@PathVariable Integer parentId, Integer pageIndex, Integer pageSize){
        Page page = courseCollectionService.getAllCourseCollection(pageIndex,pageSize,parentId);
        return new JsonResponse(200, "success", page);
    }

    @ResponseBody
    @RequestMapping("/removeCourseCollection/{collectionId}")
    public Integer deleteCourseCollection(@PathVariable Integer collectionId){
        return courseCollectionService.deleteCollection(collectionId);
    }
}
