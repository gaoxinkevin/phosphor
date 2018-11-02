package com.cafebabe.phosphor.web.controller;

import com.cafebabe.phosphor.model.dto.TeacherNameAndPageNumberDTO;
import com.cafebabe.phosphor.model.entity.Teacher;
import com.cafebabe.phosphor.service.serviceimpl.SearchServiceImpl;
import com.cafebabe.phosphor.util.JsonResponse;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocumentList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: SearchController
 *
 * create_date: 2018/10/29
 *
 * create_time: 18:27
 *
 * description: 搜索功能
 **/

@Controller
@CrossOrigin
@RequestMapping("searchInfo")
public class SearchController {

    private final SearchServiceImpl searchController;

    public SearchController(SearchServiceImpl searchController) {
        this.searchController = searchController;
    }

    @RequestMapping("searchTeacherInfo")
    @ResponseBody
    public JsonResponse teacherInfo(@RequestBody TeacherNameAndPageNumberDTO dto) throws IOException, SolrServerException {
        SolrDocumentList solrDocuments =searchController.getTeacherInfo(dto);
        System.out.println(dto);
        return new JsonResponse(20000,"成功",solrDocuments);
    }

    @RequestMapping("searchNumber")
    @ResponseBody
    public JsonResponse teacherPageNumber(@RequestBody Teacher teacher) throws IOException, SolrServerException {
        String teacherName = teacher.getTeacherName();
        Long pageNumber = searchController.pageNumberService(teacherName);
        return new JsonResponse(20000,"成功",pageNumber);
    }
}
