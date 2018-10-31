package com.cafebabe.phosphor.service;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocumentList;

import java.io.IOException;

/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: SearchService
 *
 * create_date: 2018/10/29
 *
 * create_time: 18:35
 *
 * description:
 **/

public interface SearchService {

    /**
     * 搜索得到老师的信息
     * @param teacherName 老师名称
     * @return 文档数据
     * @throws IOException 输入错误
     * @throws SolrServerException 连接错误
     */
    SolrDocumentList getTeacherInfo(String teacherName) throws IOException, SolrServerException;
}
