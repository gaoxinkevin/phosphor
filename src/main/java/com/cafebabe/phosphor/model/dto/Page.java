package com.cafebabe.phosphor.model.dto;

import lombok.*;

import java.util.List;
/**
 *
 * @author thethingyk@gmail.com
 *
 * class_name: Page
 *
 * create_date: 18-10-17
 *
 * create_time: 下午6:21
 *
 * description:数据分页模型
 **/
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Page<T> {

    /**
     * 每页显示记录数
     */
    private final Integer pageSize = 12;
    /**
     * 总记录数
     */
    private Integer totalRecord ;
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
     * 到第几条记录结束显示
     */
    private Integer endRecord;
    /**
     * 当前页显示记录对象集合
     */
    private List<T> modelList;
}
