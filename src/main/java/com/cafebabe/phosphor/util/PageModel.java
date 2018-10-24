package com.cafebabe.phosphor.util;

import lombok.*;

import java.util.List;

/**
 * @author kevingx2016@gmail.com
 * <p>
 * class_name: TeacherCourseDAO
 * <p>
 * create_date: 2018/10/22
 * <p>
 * create_time: 09:35
 * <p>
 * description: 分页
 **/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class PageModel<T> {

    /**
     * 每页显示记录数
     */
    private Integer pageSize ;

    /**
     * 总记录数
     */
    private Integer totalRecord;

    /**
     * 总页数
     */
    private Integer totalPages;

    /**
     * 当前页码
     */
    private Integer currentPageCode;

    /**
     * 从第几条记录开始显示
     */
    private Integer startRecord;

    /**
     * 到第几条记录结束显示 mysql不使用
     */
    private Integer endRecord;

    /**
     * 当前页显示记录对象集合
     */
    private List<T> modelList;

    /**
     * 冗余字段
     */
    private Integer sf;


    /**
     * 冗余字段
     */
    private String sfString;

}
