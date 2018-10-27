package com.cafebabe.phosphor.util.priceimpl;

import com.cafebabe.phosphor.model.dto.CourseInfo;
import com.cafebabe.phosphor.model.entity.Course;
import com.cafebabe.phosphor.util.Price;

import java.math.BigDecimal;
import java.util.List;
/**
 *
 * @author thethingyk@gmail.com
 *
 * class_name: PriceOtherImpl
 *
 * create_date: 18-10-23
 *
 * create_time: 下午7:19
 *
 * description:
 **/
public class PriceOtherImpl implements Price {
    @Override
    public BigDecimal getPriceCount(List<Course> courses) {
        BigDecimal price = new BigDecimal(0);
        for (Course cours : courses) {
            price.add(cours.getCoursePrice());
        }
        return price;
    }

    @Override
    public BigDecimal getPriceCountInfo(List<CourseInfo> courses) {
        BigDecimal price = new BigDecimal(0);
        for (CourseInfo cours : courses) {
            price.add(cours.getCoursePrice());
        }
        BigDecimal count= price.multiply(new BigDecimal(0.70));
        System.out.println(count);
        return count;
    }
}
