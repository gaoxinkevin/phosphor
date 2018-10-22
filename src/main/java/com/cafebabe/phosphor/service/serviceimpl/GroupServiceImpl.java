package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.dao.GroupCourseDAO;
import com.cafebabe.phosphor.dao.GroupDAO;
import com.cafebabe.phosphor.model.dto.GroupDTO;
import com.cafebabe.phosphor.model.entity.Group;
import com.cafebabe.phosphor.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.List;


/**
 *
 * @author thethingyk@gmail.com
 *
 * class_name: GroupServiceImpl
 *
 * create_date: 2018/10/9
 *
 * create_time: 19:29
 *
 * description: 套餐service层的实现类
 **/
@Controller
public class GroupServiceImpl implements GroupService {



    private final GroupDAO groupDAO;
    private final GroupCourseDAO groupCourseDAO;
    @Autowired
    public GroupServiceImpl(GroupDAO groupDAO,GroupCourseDAO groupCourseDAO) {
        this.groupDAO=groupDAO;
        this.groupCourseDAO=groupCourseDAO;
    }

    @Override
    public Integer insertGroup(GroupDTO group) {
        if ((1==groupDAO.insertGroup(toGroup(group)))
                &&(1==groupCourseDAO.insertGroupCourses(group.getCourses()))){
            return 1;
        }else{
            return 1;
        }
    }

    @Override
    public Integer updateGroup(Group group) { return groupDAO.updateGroup(group); }

    @Override
    public Integer updateGroupDiscount(BigDecimal groupDiscount, Integer groupId) {
        return groupDAO.updateGroupDiscount(groupDiscount,groupId);
    }

    @Override
    public Integer updateGroupStatus(Integer groupStatus, Integer groupId) {
        return groupDAO.updateGroupStatus(groupStatus,groupId);
    }

    @Override
    public Integer removeGroup(Integer id) { return groupDAO.removeGroup(id); }

    @Override
    public Group getGroupById(Integer id) { return groupDAO.getGroupById(id); }

    @Override
    public GroupDTO getGroupDTOById(Integer id) {
        return null;
        //return toGroupDTO(groupDAO.getGroupById(id));
    }

    @Override
    public List<Group> getGroupListAll() {
        return groupDAO.getGroupListAll();
    }

    @Override
    public List<Group> getGroupListAlive() {
        return groupDAO.getGroupListAlive();
    }

    @Override
    public List<Group> getGroupListByDiscount(BigDecimal discount) {
        return groupDAO.getGroupListByDiscount(discount);
    }

    @Override
    public List<Group> getGroupListByDiscountScope(BigDecimal minDiscount, BigDecimal maxDiscount) {
        return groupDAO.getGroupListByDiscountScope(minDiscount,maxDiscount);
    }

    private Group toGroup(GroupDTO groupDTO){
        if (groupDTO == null) {
            return null;
        }
        return new Group(groupDTO.getGroupId(),
                groupDTO.getGroupStatus(),
                groupDTO.getGroupEndTime(),
                groupDTO.getGroupName(),
                groupDTO.getGroupDiscount(),
                groupDTO.getGroupContent(),
                groupDTO.getGroupCreateTime(),
                groupDTO.getGroupSf(),
                groupDTO.getGroupPrice(),
                groupDTO.getGroupCourseNumber(),
                groupDTO.getGroupPhoto()
        );
    }

/*    private GroupDTO toGroupDTO(Group group){
        if (group == null) {
            return null;
        }
        return new GroupDTO(group.getGroupId(),
                group.getGroupStatus(),
                group.getGroupEndTime(),
                group.getGroupName(),
                group.getGroupDiscount(),
                group.getGroupContent(),
                group.getGroupCreateTime(),
                group.getGroupSf(),
                group.getGroupPrice(),
                group.getGroupCourseNumber(),
                group.getGroupPhoto(),
                groupDAO.getCourseByGroupId(group.getGroupId()));
    }*/

}
