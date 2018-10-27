package com.cafebabe.phosphor.web.controller;

import com.cafebabe.phosphor.model.dto.GroupDTO;
import com.cafebabe.phosphor.model.entity.Group;
import com.cafebabe.phosphor.service.serviceimpl.GroupServiceImpl;
import com.cafebabe.phosphor.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 * @author thethingyk@gmail.com
 *
 * class_name: GroupController
 *
 * create_date: 2018/10/9
 *
 * create_time: 20:16
 *
 * description: 套餐的业务控制层
 **/
@Controller
@CrossOrigin
@RequestMapping("/group")
public class GroupController {

    private final  GroupServiceImpl groupService;
    @Autowired
    private HttpServletRequest httpServletRequest;



    @Autowired
    public GroupController(GroupServiceImpl groupService) { this.groupService = groupService; }

    @GetMapping("groupList")
    @ResponseBody
    public JsonResponse getGroupList(){
        List<GroupDTO> groupList =groupService.getGroupListAlive();
        return new JsonResponse(200,"success",groupList);
    }

    @GetMapping("group")
    @ResponseBody
    public JsonResponse getGroup(Integer groupId){
        GroupDTO group =groupService.getGroupDTOById(groupId);
        return new JsonResponse(200,"success",group);
    }

    @GetMapping("addCourse")
    @ResponseBody
    public JsonResponse getAddCourse(Integer courseId){
        if (httpServletRequest.getSession().getAttribute("diyGroupDTO") == null) {

        }else{

        }
        return new JsonResponse(200,"success","");
    }
    @GetMapping("delCourse")
    @ResponseBody
    public JsonResponse getDelCourse(Integer courseId){
        GroupDTO group =groupService.getGroupDTOById(courseId);
        return new JsonResponse(200,"success",group);
    }

    @GetMapping("addGroup")
    @ResponseBody
    public JsonResponse getAddGroup(Integer groupId){
        GroupDTO group =groupService.getGroupDTOById(groupId);
        return new JsonResponse(200,"success",group);
    }



}
