package com.cafebabe.phosphor.web.controller;

import com.cafebabe.phosphor.model.entity.CourseCollection;
import com.cafebabe.phosphor.service.serviceimpl.CourseCollectionServiceImpl;
import com.cafebabe.phosphor.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    @RequestMapping("/getCourseCollectionList/{parentPhone}")
    public JsonResponse getCourseList(@PathVariable String parentPhone){
        List<CourseCollection> courseCollectionList = courseCollectionService.getAllCourseCollection(parentPhone);
        return new JsonResponse(200, "success", courseCollectionList);
    }

    @ResponseBody
    @RequestMapping("/removeCourseCollection/{collectionId}")
    public Integer deleteCourseCollection(@PathVariable Integer collectionId){
        return courseCollectionService.deleteCollection(collectionId);
    }
}
