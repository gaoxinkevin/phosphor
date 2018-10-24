package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.dao.ChildDAO;
import com.cafebabe.phosphor.model.dto.ChildrenInfoDto;
import com.cafebabe.phosphor.model.entity.Child;
import com.cafebabe.phosphor.service.ChildService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: ChildServiceImpl
 *
 * create_date: 2018/9/26
 *
 * create_time: 16:27
 *
 * description: ChildeService的实现类
 **/

@Service
public class ChildServiceImpl implements ChildService {

    private final ChildDAO childDAO;

    @Autowired
    public ChildServiceImpl(ChildDAO childDAO) {
        this.childDAO = childDAO;
    }

    @Override
    public List<ChildrenInfoDto> getChildInfo(Integer parentId) {
        return childDAO.getChildInfoDao(parentId);
    }

    @Override
    public boolean insertChildService(Child child) {
        return 0 != childDAO.insertChild(child);
    }

    @Override
    public boolean deleteChild(Child child) {
        Integer  childId = child.getChildId();
        return 1 == childDAO.deleteByPrimaryKey(childId);
    }

    @Override
    public boolean updateChild(Child child) {
        int row = childDAO.updateByPrimaryKey(child);
        return row == 1;
    }
}
