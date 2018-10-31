package com.cafebabe.phosphor.dao;

import com.cafebabe.phosphor.model.entity.Suggest;

import java.util.List;

/**
 * SuggestDAO继承基类
 */
public interface SuggestDAO extends MyBatisBaseDao<Suggest, Integer> {

    /**
     *
     * @return
     */
    List<Suggest> getSuggestByCourse( Integer courseId);
}