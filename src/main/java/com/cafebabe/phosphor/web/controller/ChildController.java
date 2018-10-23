package com.cafebabe.phosphor.web.controller;

import com.cafebabe.phosphor.model.dto.ChildrenInfoDto;
import com.cafebabe.phosphor.model.entity.Child;
import com.cafebabe.phosphor.service.serviceimpl.ChildServiceImpl;
import com.cafebabe.phosphor.service.serviceimpl.ParentServiceImpl;
import com.cafebabe.phosphor.util.JsonResponse;

import com.cafebabe.phosphor.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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

    private final ChildServiceImpl childService;
    private final ParentServiceImpl parentService;
    @Autowired(required = false)
    private  HttpServletRequest httpServletRequest;


    @Autowired
    public ChildController(ChildServiceImpl childService, ParentServiceImpl parentService) {
        this.childService = childService;
        this.parentService = parentService;
    }


    @RequestMapping("childInfo")
    @ResponseBody
    public JsonResponse childrenInfo(){
        String parentPhone = (String) httpServletRequest.getSession().getAttribute("userLoginPhone");
        Integer parentId = parentService.getAllInfoAboutParentService(parentPhone).getParentId();
        List<ChildrenInfoDto> list1  = RedisUtil.getList("childAllINfo"+parentPhone);
        if (list1 !=null && list1.size()!= 0){
            return new JsonResponse(20000,"成功",list1);
        }else {
            List<ChildrenInfoDto> list = childService.getChildInfo(parentId);
            RedisUtil.setList("childAllINfo"+parentPhone,list);
            return new JsonResponse(20000,"成功",list);
        }
    }

    @RequestMapping("insertChild")
    @ResponseBody
    public JsonResponse saveChild(@RequestBody Child child){
        boolean result = childService.insertChildService(child);
        System.out.println(child.getChildBirthday());
        if (result){
            return new JsonResponse(20000,"添加成功",true);
        }else {
            return new JsonResponse(30000,"添加失败",false);
        }

    }
}
