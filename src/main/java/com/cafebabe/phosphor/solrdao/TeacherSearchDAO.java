package com.cafebabe.phosphor.solrdao;


import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocumentList;

import java.io.IOException;

/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: TeacherSearchDAO
 *
 * create_date: 2018/10/28
 *
 * create_time: 22:02
 *
 * description: 教室查询类
 **/

public interface TeacherSearchDAO {

    /**
     * 根据老师名称，查询老师
     * @param teacherName 教室名称
     * @return 关于教师的文档集
     */
    SolrDocumentList getTeacherListByTeacherName(String teacherName) throws IOException, SolrServerException;

    /**
     * 根据老师的描述，获取老师的信息
     * @param teacherDesc 老师的面熟
     * @return 关于教师的文档集
     */
    SolrDocumentList getTeacherListByTeacherDesc(String teacherDesc) throws IOException, SolrServerException;
}
