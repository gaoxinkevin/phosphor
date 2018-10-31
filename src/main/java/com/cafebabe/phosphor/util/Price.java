package com.cafebabe.phosphor.util;

import com.cafebabe.phosphor.model.dto.CourseInfo;
import com.cafebabe.phosphor.model.entity.Course;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author thethingyk@gmail.com
 *
 * class_name: Price
 *
 * create_date: 18-10-22
 *
 * create_time: 下午8:24
 *
 * description:
 **/
public interface Price {
    /**
     * 获取套餐价格
     * @param courses 套餐包含的课程
     * @return 套餐价格
     */
    BigDecimal getPriceCount(List<Course> courses);

    /**
     * 获取套餐价格
     * @param courses 套餐包含的课程
     * @return 套餐价格
     */
    BigDecimal getPriceCountInfo(List<CourseInfo> courses);
}
