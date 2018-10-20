package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.dao.GroupDAO;
import com.cafebabe.phosphor.model.entity.Group;
import com.cafebabe.phosphor.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

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

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private final GroupDAO groupDAO;

    public GroupServiceImpl(GroupDAO groupDAO) { this.groupDAO=groupDAO; }

    @Override
    public Integer insertGroup(Group group) { return groupDAO.insertGroup(group); }

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
    public List<Group> getGroupListAll() { return groupDAO.getGroupListAll(); }

    @Override
    public List<Group> getGroupListAlive() { return groupDAO.getGroupListAlive(); }

    @Override
    public List<Group> getGroupListByDiscount(BigDecimal discount) {
        return groupDAO.getGroupListByDiscount(discount);
    }

    @Override
    public List<Group> getGroupListByDiscountScope(BigDecimal minDiscount, BigDecimal maxDiscount) {
        return groupDAO.getGroupListByDiscountScope(minDiscount,maxDiscount);
    }
}
