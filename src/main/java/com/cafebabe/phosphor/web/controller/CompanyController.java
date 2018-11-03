package com.cafebabe.phosphor.web.controller;

import com.cafebabe.phosphor.model.entity.Company;
import com.cafebabe.phosphor.service.serviceimpl.CompanyServiceImpl;
import com.cafebabe.phosphor.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author thethingyk@gmail.com
 *
 * class_name: CompanyController
 *
 * create_date: 2018/10/8
 *
 * create_time: 10:30
 *
 * description:公司数据分发界面
 **/

@Controller
@CrossOrigin
@RequestMapping("/company")
public class CompanyController {

    private static final String COMPANY_ID = "companyId";
    private HttpServletRequest httpServletRequest;
    private final CompanyServiceImpl companyService;
    @Autowired
    public CompanyController(CompanyServiceImpl companyService,HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
        this.companyService = companyService; }

    @RequestMapping("company")
    @ResponseBody
    public JsonResponse getCompany(){
        if (httpServletRequest.getSession().getAttribute(COMPANY_ID) == null) {
            return new JsonResponse(40400,"can not find resourse",null);
        }
        Integer companyId = (Integer) httpServletRequest.getSession().getAttribute(COMPANY_ID);
        Company company = companyService.getCompanyById(companyId);
        if (company == null) {
            return new JsonResponse(40400,"can not find resourse",null);
        }
        return new JsonResponse(20000,"success",company);
    }

}
