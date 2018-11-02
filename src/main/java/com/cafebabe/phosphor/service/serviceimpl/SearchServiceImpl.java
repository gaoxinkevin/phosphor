package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.model.dto.TeacherNameAndPageNumberDTO;
import com.cafebabe.phosphor.service.SearchService;
import com.cafebabe.phosphor.solrdao.solrdaoimpl.TeacherSearchDaoImpl;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocumentList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: SearchServiceImpl
 *
 * create_date: 2018/10/29
 *
 * create_time: 18:43
 *
 * description: 搜索impl
 **/

@Service
public class SearchServiceImpl implements SearchService {

    private final TeacherSearchDaoImpl teacherSearchDao;

    @Autowired
    public SearchServiceImpl(TeacherSearchDaoImpl teacherSearchDao) {
        this.teacherSearchDao = teacherSearchDao;
    }

    @Override
    public SolrDocumentList getTeacherInfo(TeacherNameAndPageNumberDTO dto) throws IOException, SolrServerException {
        return teacherSearchDao.getTeacherListByTeacherName(dto);
    }

    @Override
    public Long pageNumberService(String teacherName) throws IOException, SolrServerException {
        return teacherSearchDao.pageNumber(teacherName);
    }
}
