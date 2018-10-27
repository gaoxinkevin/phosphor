package com.cafebabe.phosphor.web.controller;

import com.cafebabe.phosphor.model.dto.CourseInfo;
import com.cafebabe.phosphor.model.dto.GroupDTO;
import com.cafebabe.phosphor.model.entity.Course;
import com.cafebabe.phosphor.model.entity.Group;
import com.cafebabe.phosphor.service.serviceimpl.GroupServiceImpl;
import com.cafebabe.phosphor.util.JsonResponse;
import com.mysql.cj.x.protobuf.Mysqlx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    private final  String diyGroupDTOStr = "diyGroupDTO";
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
        if (groupId == null) {
            groupId = (Integer) httpServletRequest.getSession().getAttribute("groupId");
            if (groupId == null) {
                return new JsonResponse(40000,"success","找不到套餐");
            }else{
                GroupDTO group =groupService.getGroupDTOById(groupId);
                httpServletRequest.getSession().removeAttribute("groupId");
                return new JsonResponse(200,"success",group);
            }
        }
        GroupDTO group =groupService.getGroupDTOById(groupId);
        return new JsonResponse(200,"success",group);
    }

    @RequestMapping("addCourse")
    @ResponseBody
    public JsonResponse getAddCourse(@RequestBody Course course){

        if (httpServletRequest.getSession().getAttribute(diyGroupDTOStr) == null) {
            if (course.getCourseId()!= null) {
                GroupDTO diyGroupDTO= groupService.createGroup(course.getCourseId());
                httpServletRequest.getSession().setAttribute(diyGroupDTOStr,diyGroupDTO);
                return new JsonResponse(20000,"success",diyGroupDTO);
            }else {
                return new JsonResponse(40000,"error","没有该课程");
            }

        }else{
            GroupDTO diyGroupDTO =(GroupDTO) httpServletRequest.getSession().getAttribute(diyGroupDTOStr);
            diyGroupDTO=groupService.addCourseToGroup(diyGroupDTO,course.getCourseId());
            httpServletRequest.getSession().setAttribute(diyGroupDTOStr,diyGroupDTO);
            return new JsonResponse(30000,"success",diyGroupDTO);
        }
    }
    @RequestMapping("delCourse")
    @ResponseBody
    public JsonResponse getDelCourse(@RequestBody Course course){
        if (course.getCourseId()== null) {
            return new JsonResponse(40000,"error","没有该课程");
        }
        if (httpServletRequest.getSession().getAttribute(diyGroupDTOStr) != null) {
            System.out.println(course.getCourseId());
            GroupDTO diyGroupDTO =(GroupDTO) httpServletRequest.getSession().getAttribute(diyGroupDTOStr);
            diyGroupDTO=groupService.delCourseFromCourse(diyGroupDTO,course.getCourseId());
            httpServletRequest.getSession().setAttribute(diyGroupDTOStr,diyGroupDTO);
            return new JsonResponse(30000,"success",diyGroupDTO);
        }
        return new JsonResponse(50000,"error","程序执行失败");
    }

    @RequestMapping("addGroup")
    @ResponseBody
    public JsonResponse getAddGroup(){
        if (httpServletRequest.getSession().getAttribute(diyGroupDTOStr) == null) {
                return new JsonResponse(50000,"error","没有该套餐");
        }else{
            GroupDTO diyGroupDTO =(GroupDTO) httpServletRequest.getSession().getAttribute(diyGroupDTOStr);
            if (diyGroupDTO.getCourseInfos().size()>1&&diyGroupDTO.getCourseInfos().size()<5){
                Integer groupId = groupService.insertGroupDTO(diyGroupDTO);
                return new JsonResponse(30000,"success",groupId);
            }else {
                return new JsonResponse(40000,"error","套餐样式出错");
            }
        }
    }

    @RequestMapping("delSession")
    @ResponseBody
    public JsonResponse getDelSession(){
        httpServletRequest.getSession().removeAttribute(diyGroupDTOStr);
        return new JsonResponse(200,"success","删除成功!");
    }


}
