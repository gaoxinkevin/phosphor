package com.cafebabe.phosphor.solrdao;


import com.cafebabe.phosphor.model.dto.TeacherNameAndPageNumberDTO;
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
     * @param dto 教师姓名,页面数据
     * @return 关于教师的文档集
     * @throws IOException 写入失败
     * @throws SolrServerException 连接失败
     */
    SolrDocumentList getTeacherListByTeacherName(TeacherNameAndPageNumberDTO dto) throws IOException, SolrServerException;

    /**
     * 根据老师文档查询 老师
     * @param teacherDesc 老师描述的模糊查询
     * @return 老师数据
     * @throws IOException 写入失败
     * @throws SolrServerException 连接失败
     */
    SolrDocumentList getTeacherListByTeacherDesc(String teacherDesc) throws IOException, SolrServerException;

    /**
     * 分页的数量
     * @param teacherName 老师姓名的模糊查询
     * @return 老师分页的数量
     * @throws IOException 写入失败
     * @throws SolrServerException 连接失败
     */
    Long pageNumber(String teacherName) throws IOException, SolrServerException;
}
