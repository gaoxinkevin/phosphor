package com.cafebabe.phosphor.web.controller;


import com.cafebabe.phosphor.service.serviceimpl.ParentServiceImpl;
import com.cafebabe.phosphor.util.JsonResponse;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/**
 * @author supersuntangao@gmail.com
 * <p>
 * class_name: ParentController
 * <p>
 * create_date: 2018/9/27
 * <p>
 * create_time: 15:28
 * <p>
 * description: 家长控制模块
 **/

@Controller
@CrossOrigin
@RequestMapping("/parent")
public class ParentController {

    private final ParentServiceImpl parentService;
    private final HttpServletRequest httpServletRequest;

    @Autowired
    public ParentController(ParentServiceImpl parentService, HttpServletRequest httpServletRequest) {
        this.parentService = parentService;
        this.httpServletRequest = httpServletRequest;
    }


    @ResponseBody
    @PostMapping("parentImgUrl")
    public JsonResponse parentImgUrl(){
        String parentPhone = (String) httpServletRequest.getSession().getAttribute("userLoginPhone");
        String parentImgUrl =  parentService.getParentImgUrlService(parentPhone);
        return new JsonResponse(20000,"成功",parentImgUrl);
    }

    @ResponseBody
    @RequestMapping("isSessionExit")
    public JsonResponse isSessionExit(){
        String parentPhone = (String) httpServletRequest.getSession().getAttribute("userLoginPhone");
        if (parentPhone!=null){
            return new JsonResponse(20000,"成功",parentPhone);
        }else {
            return new JsonResponse(30000,"session不存在",null);
        }
    }
}
