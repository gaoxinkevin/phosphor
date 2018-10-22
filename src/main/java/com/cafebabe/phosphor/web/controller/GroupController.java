package com.cafebabe.phosphor.web.controller;

import com.cafebabe.phosphor.model.entity.Group;
import com.cafebabe.phosphor.service.serviceimpl.GroupServiceImpl;
import com.cafebabe.phosphor.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @Autowired
    private final  GroupServiceImpl groupService;

    public GroupController(GroupServiceImpl groupService) { this.groupService = groupService; }

    @GetMapping("groupList")
    @ResponseBody
    public JsonResponse getGroupList(){
        List<Group> groupList =groupService.getGroupListAll();
        return new JsonResponse(200,"success",groupList);
    }

    @GetMapping("group")
    @ResponseBody
    public JsonResponse getGroup(Integer groupId){
        Group group =groupService.getGroupById(groupId);
        return new JsonResponse(200,"success",group);
    }
}
