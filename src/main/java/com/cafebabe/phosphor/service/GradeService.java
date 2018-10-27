package com.cafebabe.phosphor.service;

import com.cafebabe.phosphor.model.dto.GradeInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author weijincong@outlook.com
 *
 * class_name: GradeService
 *
 * create_date: 2018/10/25
 *
 * create_time: 9:09
 *
 * description: 成绩信息处理
 **/

@Service
public interface GradeService {

    List<GradeInfo> getGradeByChild(Integer childId);
}
