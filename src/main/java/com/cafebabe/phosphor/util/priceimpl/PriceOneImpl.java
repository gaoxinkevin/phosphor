package com.cafebabe.phosphor.util.priceimpl;

import com.cafebabe.phosphor.model.dto.CourseInfo;
import com.cafebabe.phosphor.model.entity.Course;
import com.cafebabe.phosphor.util.Price;

import java.math.BigDecimal;
import java.util.List;

public class PriceOneImpl implements Price {
    @Override
    public BigDecimal getPriceCount(List<Course> courses) {
        return courses.get(0).getCoursePrice();
    }

    @Override
    public BigDecimal getPriceCountInfo(List<CourseInfo> courses) {
        return courses.get(0).getCoursePrice();
    }
}
