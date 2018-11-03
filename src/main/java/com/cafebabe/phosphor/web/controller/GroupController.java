package com.cafebabe.phosphor.web.controller;

import com.cafebabe.phosphor.model.dto.CourseInfo;
import com.cafebabe.phosphor.model.dto.GroupDTO;
import com.cafebabe.phosphor.model.entity.Course;
import com.cafebabe.phosphor.service.serviceimpl.CourseServiceImpl;
import com.cafebabe.phosphor.service.serviceimpl.GroupServiceImpl;
import com.cafebabe.phosphor.util.JsonResponse;
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

    private static final String GROUP_ID = "groupId";
    private static final Integer MAX_COURSE = 4;
    private final  GroupServiceImpl groupService;
    private final CourseServiceImpl courseService;
    private final  String diyGroupDTOStr = "diyGroupDTO";
    private HttpServletRequest httpServletRequest;

    @Autowired
    public GroupController(GroupServiceImpl groupService,CourseServiceImpl courseService,HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
        this.courseService = courseService;
        this.groupService = groupService;
    }

    @RequestMapping("groupList")
    @ResponseBody
    public JsonResponse getGroupList(){
        List<GroupDTO> groupList =groupService.getGroupListAlive();
        return new JsonResponse(200,"success",groupList);
    }

    @RequestMapping("group")
    @ResponseBody
    public JsonResponse getGroup(){
        if (httpServletRequest.getSession().getAttribute(GROUP_ID) != null) {
            Integer groupId = (Integer) httpServletRequest.getSession().getAttribute(GROUP_ID);
            if (groupId == null) {
                return new JsonResponse(40000,"success","找不到套餐");
            }else{
                GroupDTO group =groupService.getGroupDTOById(groupId);
                return new JsonResponse(20000,"success",group);
            }
        }
        return new JsonResponse(50000,"error","找不到数据");
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

            CourseInfo conflictCourseInfo = courseService.getConflictCourseInfo(diyGroupDTO.getCourseInfos(),course.getCourseId());

            if (conflictCourseInfo == null) {
                if(diyGroupDTO.getCourseInfos().size()>=MAX_COURSE){
                    return new JsonResponse(50000,"最多只能添加四个课程","");
                }
                diyGroupDTO=groupService.addCourseToGroup(diyGroupDTO,course.getCourseId());
                httpServletRequest.getSession().setAttribute(diyGroupDTOStr,diyGroupDTO);
                return new JsonResponse(30000,"success",diyGroupDTO);
            }else {
                if(conflictCourseInfo.getCourseId().equals(course.getCourseId())){
                    return new JsonResponse(40100,"不能重复添加课程","");
                }else {
                    return new JsonResponse(40200,"该课和已选课程《"+conflictCourseInfo.getCourseName()+"》有时间冲突","");
                }
            }
        }
    }

    @RequestMapping("diyGroup")
    @ResponseBody
    public JsonResponse getDiyGroup(){

        if (httpServletRequest.getSession().getAttribute(diyGroupDTOStr) == null) {
            return new JsonResponse(40000,"error","没有该课程");
        }else{
            GroupDTO diyGroupDTO =(GroupDTO) httpServletRequest.getSession().getAttribute(diyGroupDTOStr);
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

            if (diyGroupDTO.getCourseInfos().size()>1&&diyGroupDTO.getCourseInfos().size()<=MAX_COURSE){
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
        return new JsonResponse(20000,"success","删除成功!");
    }

    @RequestMapping("groupRecommend")
    @ResponseBody
    public JsonResponse getGroupRecommend(){
        List<GroupDTO> groupDTOS = groupService.getGroupListRecommend();
        return new JsonResponse(20000,"success",groupDTOS);
    }

    @RequestMapping("groupByTime")
    @ResponseBody
    public JsonResponse getGroupByTime(){
        List<GroupDTO> groupDTOS = groupService.getGroupByTime();
        return new JsonResponse(20000,"success",groupDTOS);
    }

    @RequestMapping("groupByPriceAsc")
    @ResponseBody
    public JsonResponse getGroupByPriceAsc(){
        List<GroupDTO> groupDTOS = groupService.getGroupByPriceAsc();
        return new JsonResponse(20000,"success",groupDTOS);
    }
    @RequestMapping("groupByPriceDesc")
    @ResponseBody
    public JsonResponse getGroupByPriceDesc(){
        List<GroupDTO> groupDTOS = groupService.getGroupByPriceDesc();
        return new JsonResponse(20000,"success",groupDTOS);
    }



}
