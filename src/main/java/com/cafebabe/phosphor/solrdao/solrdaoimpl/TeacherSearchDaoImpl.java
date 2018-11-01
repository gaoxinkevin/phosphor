package com.cafebabe.phosphor.solrdao.solrdaoimpl;


import com.cafebabe.phosphor.model.dto.TeacherNameAndPageNumberDTO;
import com.cafebabe.phosphor.solrdao.TeacherSearchDAO;

import com.cafebabe.phosphor.util.SolrUtil;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

import org.springframework.stereotype.Service;

import java.io.IOException;


/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: TeacherSearchDaoImpl
 *
 * create_date: 2018/10/28
 *
 * create_time: 22:03
 *
 * description: 教室搜索实现类
 **/

@Service
public class TeacherSearchDaoImpl implements TeacherSearchDAO {

    private final static String URL = "http://47.100.247.29:8080/solr/collection_teacher";
    private final static HttpSolrClient CLIENT = SolrUtil.connSolr(URL);

    @Override
    public SolrDocumentList getTeacherListByTeacherName(TeacherNameAndPageNumberDTO dto) throws IOException, SolrServerException {
        //查询设置（使用子类SolrQuery,因为子类的方法，永远要多余或等于父类)
        SolrQuery solrQuery = new SolrQuery();
        //不需要分类，不需要进行过滤（q 查询，fq 过滤）
        solrQuery.set("q","teacherName:"+dto.getTeacherName());
//        solrQuery.set("fq","teacherName:"+teacherName); 按照名字过滤
        //可进行排序搜索
        if (dto.getPageNumber()==0){
            solrQuery.setStart(dto.getPageNumber());
        }else if (dto.getPageNumber()==1){
            solrQuery.setStart(3);
        }
        else {
            solrQuery.setStart(dto.getPageNumber()*3);
        }
        solrQuery.setRows(3);
        QueryResponse queryResponse = CLIENT.query(solrQuery);
        return queryResponse.getResults();
    }

    @Override
    public SolrDocumentList getTeacherListByTeacherDesc(String teacherDesc) throws IOException, SolrServerException {
       SolrQuery solrQuery = new SolrQuery();
       solrQuery.setQuery("teacherDesc:"+teacherDesc);
       solrQuery.addSort("teacherWorktime", SolrQuery.ORDER.desc);
       QueryResponse queryResponse = CLIENT.query(solrQuery);
       return queryResponse.getResults();
    }

    @Override
    public Long pageNumber(String teacherName) throws IOException, SolrServerException {
        int pageSize  = 3;
        SolrQuery solrQuery = new SolrQuery();
        //不需要分类，不需要进行过滤（q 查询，fq 过滤）
        solrQuery.set("q","teacherName:"+teacherName);
        solrQuery.setRows(3);
        QueryResponse queryResponse =  CLIENT.query(solrQuery);
        long pageNumber = queryResponse.getResults().getNumFound();
        System.out.println("pageNumber:"+pageNumber);
        if (pageNumber ==0){
            return pageNumber;
        }
        else if (pageNumber <= pageSize){
            return 1L;
        }else if (pageNumber%pageSize != 0){
            return pageNumber/3+1;
        }else {
            return pageNumber/3;
        }

    }


}
