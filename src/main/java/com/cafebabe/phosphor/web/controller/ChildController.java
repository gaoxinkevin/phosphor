package com.cafebabe.phosphor.web.controller;

import com.cafebabe.phosphor.model.entity.Child;
import com.cafebabe.phosphor.service.serviceimpl.ChildServiceImpl;
import com.cafebabe.phosphor.util.JsonResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: ChildController
 *
 * create_date: 2018/9/26
 *
 * create_time: 16:33
 *
 * description: 跳转分发数据
 **/


@Controller
@CrossOrigin
@RequestMapping("/child")
public class ChildController {

    @Autowired
    private final ChildServiceImpl childService;

    public ChildController(ChildServiceImpl childService) {
        this.childService = childService;
    }


    @RequestMapping("/findAllChild")
    @ResponseBody
    public JsonResponse findAllChild(){
        List<Child> children = childService.getChildService();
        return new JsonResponse(200,"成功",children);
    }

}
