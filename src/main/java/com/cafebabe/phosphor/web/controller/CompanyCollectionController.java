package com.cafebabe.phosphor.web.controller;

import com.cafebabe.phosphor.model.dto.CompanyCollectionDTO;
import com.cafebabe.phosphor.model.entity.CompanyCollection;
import com.cafebabe.phosphor.service.serviceimpl.CompanyCollectionServiceImpl;
import com.cafebabe.phosphor.util.JsonResponse;
import com.cafebabe.phosphor.util.PageModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author kevingx2016@gmail.com
 * <p>
 * class_name: CompanyCollectionController
 * <p>
 * create_date: 2018/10/23
 * <p>
 * create_time: 19:36
 * <p>
 * description: 公司收藏的业务控制层
 **/
@Controller
@CrossOrigin
@RequestMapping("/companyCollection")
public class CompanyCollectionController {
    @Autowired
    private final CompanyCollectionServiceImpl companyCollectionService;

    public CompanyCollectionController(CompanyCollectionServiceImpl companyCollectionService) {
        this.companyCollectionService = companyCollectionService;
    }

    /**
     * 根据父母ID获取公司收藏列表
     *
     * @param pageModel 含有父母ID的分页信息
     * @return 含有公司收藏信息的Json数据
     */
    @RequestMapping("getCompanyCollectionList")
    @ResponseBody
    public JsonResponse getFeedbackList(@RequestBody PageModel<CompanyCollectionDTO> pageModel) {
        return new JsonResponse(200, "success", companyCollectionService.getCompanyCollectionList(pageModel));
    }

    /**
     * 根据公司收藏ID删除收藏
     *
     * @param companyCollectionId 公司收藏ID
     * @return 含有受影响行数的Json数据
     */
    @RequestMapping("removeCompanyCollection/{companyCollectionId}")
    @ResponseBody
    public JsonResponse removeCompanyCollection(@PathVariable Integer companyCollectionId) {
        return new JsonResponse(200, "success", companyCollectionService.removeCompanyCollection(companyCollectionId));
    }

    /**
     * 添加公司收藏
     *
     * @param companyCollection 公司信息
     * @return 含有受影响行数的Json数据
     */
    @RequestMapping("insertCompanyCollection")
    @ResponseBody
    public JsonResponse insertCompanyCollection(@RequestBody CompanyCollection companyCollection) {
        return new JsonResponse(200, "success", companyCollectionService.insertCompanyCollection(companyCollection));
    }

}
