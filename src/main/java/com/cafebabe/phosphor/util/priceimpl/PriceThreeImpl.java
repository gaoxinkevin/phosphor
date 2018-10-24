package com.cafebabe.phosphor.util.priceimpl;

import com.cafebabe.phosphor.model.entity.Course;
import com.cafebabe.phosphor.util.Price;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author thethingyk@gmail.com
 * 
 * class_name: PriceThreeImpl
 * 
 * create_date: 18-10-22
 *
 * create_time: 下午9:10
 *
 * description: 两件课程的打折方式
 **/
public class PriceThreeImpl implements Price {
    @Override
    public BigDecimal getPriceCount(List<Course> courses) {
        BigDecimal price = new BigDecimal(0);
        for (Course cours : courses) {
            price.add(cours.getCoursePrice());
        }
        return price;
    }
}
