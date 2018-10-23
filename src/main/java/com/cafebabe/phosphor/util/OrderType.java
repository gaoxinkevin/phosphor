package com.cafebabe.phosphor.util;

import lombok.Getter;

/**
 *
 * @author thethingyk@gmail.com
 *
 * class_name: OrderType
 *
 * create_date: 18-10-22
 *
 * create_time: 下午2:17
 *
 * description:
 **/
@Getter
public enum OrderType {
    /**
     *
     */
    Activity(0, "活动"), Course(1, "课程"), Group(2, "套餐");
    /**
     * 类型id
     */
    int typeId;
    /**
     * 类型名
     */
    String typeName;

    OrderType(int typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

}
