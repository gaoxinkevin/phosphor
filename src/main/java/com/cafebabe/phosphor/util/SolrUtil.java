package com.cafebabe.phosphor.util;

import org.apache.solr.client.solrj.impl.HttpSolrClient;

/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: SolrUtil
 *
 * create_date: 2018/10/28
 *
 * create_time: 21:46
 *
 * description: 连接Solr数据库，完成搜索请求
 **/

public class SolrUtil {

    /**
     * 用来呢连接数据库
     * @param url 向哪个数据库进行请求连接
     */
    public static HttpSolrClient connSolr(String url){

        return new HttpSolrClient.Builder(url).
                withConnectionTimeout(10000).
                withSocketTimeout(60000)
                .build();
    }
}
