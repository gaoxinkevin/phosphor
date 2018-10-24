package com.cafebabe.phosphor.web.controller;

import com.cafebabe.phosphor.model.dto.ChildrenInfoDto;
import com.cafebabe.phosphor.model.entity.Child;
import com.cafebabe.phosphor.service.serviceimpl.ChildServiceImpl;
import com.cafebabe.phosphor.service.serviceimpl.ParentServiceImpl;
import com.cafebabe.phosphor.util.JsonResponse;

import com.cafebabe.phosphor.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    private final HttpServletRequest httpServletRequest;


    @Autowired
    public ChildController(ChildServiceImpl childService, HttpServletRequest httpServletRequest, ParentServiceImpl parentService) {
        this.childService = childService;
        this.httpServletRequest = httpServletRequest;
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
        String parentPhone = (String) httpServletRequest.getSession().getAttribute("userLoginPhone");
        boolean result = childService.insertChildService(child);
        RedisUtil.del("childAllINfo"+parentPhone);
        if (result){
            return new JsonResponse(20000,"添加成功",true);
        }else {
            return new JsonResponse(30000,"添加失败",false);
        }

    }

    @RequestMapping("deleteChild")
    @ResponseBody
    public JsonResponse removeChild(@RequestBody Child child){
        String parentPhone = (String) httpServletRequest.getSession().getAttribute("userLoginPhone");
        boolean result = childService.deleteChild(child);
        if (result){
            RedisUtil.del("childAllINfo"+parentPhone);
            return new JsonResponse(20000,"删除成功",true);
        }else {
            return new JsonResponse(30000,"删除失败",false);
        }
    }

    @RequestMapping("modifyChild")
    @ResponseBody
    public JsonResponse modifyChild(@RequestBody Child child){
        boolean result = childService.updateChild(child);
        String parentPhone = (String) httpServletRequest.getSession().getAttribute("userLoginPhone");
        if (result){
            RedisUtil.del("childAllINfo"+parentPhone);
            return new JsonResponse(20000,"删除成功",true);
        }else {
            return new JsonResponse(30000,"删除失败",false);
        }
    }

    @RequestMapping("singleChildInfo")
    @ResponseBody
    public JsonResponse singleChildInfo(@RequestBody ChildrenInfoDto childrenInfoDto){
        Integer id = childrenInfoDto.getChildId();
        System.out.println(childrenInfoDto);
        System.out.println(id);
        return new JsonResponse(2000,"成功",childService.getSingleChildInfo(id));
    }

    @RequestMapping("singleChildInfoNoCourse")
    @ResponseBody
    public JsonResponse singleChildInfoNoCourse(@RequestBody Child child){
        return new JsonResponse(20000,"成功",childService.getSingleChildInfoNoCourseService(child.getChildId()));
    }
}
