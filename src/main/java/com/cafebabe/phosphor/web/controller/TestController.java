package com.cafebabe.phosphor.web.controller;


import com.cafebabe.phosphor.solrdao.solrdaoimpl.TeacherSearchDaoImpl;
import com.cafebabe.phosphor.util.JsonResponse;
import com.cafebabe.phosphor.util.SolrUtil;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: TestController
 *
 * create_date: 2018/10/27
 *
 * create_time: 14:29
 *
 * description:
 **/

@Controller
@CrossOrigin
@RequestMapping("/test")
public class TestController {


    private final TeacherSearchDaoImpl teacherService;

    private final static String URL = "http://47.100.247.29:8080/solr/collection1";

    private final static String URL_MYSQL = "http://47.100.247.29:8080/solr/collection_mysql";

    private final static String URL_ACTIVITY = "http://47.100.247.29:8080/solr/collection_activity";

    @Autowired
    public TestController(TeacherSearchDaoImpl teacherService1) {

        this.teacherService = teacherService1;
    }

    /**
     *  向solr进行数据库插入操作
     * @throws IOException  输入异常
     * @throws SolrServerException  无法查询
     */
    @RequestMapping("test")
    public void test() throws IOException, SolrServerException {
        HttpSolrClient httpSolrClient =SolrUtil.connSolr(URL);

        SolrInputDocument document = new SolrInputDocument();
        document.addField("id","10001");
        document.addField("name","你好");

        SolrInputDocument  document1  = new SolrInputDocument();
        document1.addField("id","10002");
        document1.addField("name","你好啊");

        Collection<SolrInputDocument> docs = new ArrayList<>();
        docs.add(document);
        docs.add(document1);

        httpSolrClient.add(docs);

        httpSolrClient.commit();

    }

    /**
     * 向数据库进行请求操作
     * @throws IOException  输入异常
     * @throws SolrServerException  无法查询
     */

    @RequestMapping("search")
    public void testSearch() throws IOException, SolrServerException {
        HttpSolrClient httpSolrClient = new HttpSolrClient.Builder(URL).
                withConnectionTimeout(10000).
                withSocketTimeout(60000)
                .build();
        SolrQuery solrQuery =  new SolrQuery();
        solrQuery.set("q","name:你好");
        QueryResponse queryResponse = httpSolrClient.query(solrQuery);
        SolrDocumentList  solrDocuments = queryResponse.getResults();
        Long num = solrDocuments.getNumFound();
        System.out.println(num);
        for (SolrDocument sd:solrDocuments){
            String id = (String) sd.get("id");
            System.out.println(id);
        }
    }

    @RequestMapping("companySearch")
    public void testCompanySearch() throws IOException, SolrServerException {
        HttpSolrClient httpSolrClient = new HttpSolrClient.Builder(URL_MYSQL).
                withConnectionTimeout(10000).
                withSocketTimeout(60000)
                .build();
        SolrQuery solrQuery  = new SolrQuery();
        solrQuery.set("date","2018-10-24T21:35:14Z");
        QueryResponse queryResponse = httpSolrClient.query(solrQuery);
        SolrDocumentList solrDocuments  = queryResponse.getResults();
        Long num  =  solrDocuments.getNumFound();
        System.out.println(num);
        for (SolrDocument sd : solrDocuments){
            System.out.println(sd);
        }

    }

    @RequestMapping("activitySearch")
    public void testActivitySearch() throws IOException, SolrServerException {

        HttpSolrClient httpSolrClient = new HttpSolrClient.Builder(URL_ACTIVITY).
                withConnectionTimeout(10000).
                withSocketTimeout(60000)
                .build();
        SolrQuery solrQuery  = new SolrQuery();

        solrQuery.set("q","activityAddress:苏州工业园区创意产业园4幢B座2楼");
        QueryResponse queryResponse = httpSolrClient.query(solrQuery);
        SolrDocumentList solrDocuments  = queryResponse.getResults();
        Long num  =  solrDocuments.getNumFound();
        System.out.println(num);
        for (SolrDocument sd : solrDocuments){
            System.out.println(sd);
        }

    }

    @RequestMapping("teacherSearch")
    @ResponseBody
    public JsonResponse teacherSearch() throws IOException, SolrServerException {
        List list = new ArrayList();
        list.add(teacherService.getTeacherListByTeacherName("强"));
        System.out.println(teacherService.getTeacherListByTeacherName("强"));
        list.add(teacherService.getTeacherListByTeacherDesc("有丰富的软件开发与培训的经验"));
        System.out.println(teacherService.getTeacherListByTeacherDesc("有丰富的软件开发与培训的经验"));
        return new JsonResponse(20000,"成功",list);
    }
}
