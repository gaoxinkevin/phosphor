package com.cafebabe.phosphor.web.controller;

import com.cafebabe.phosphor.model.entity.Company;
import com.cafebabe.phosphor.service.serviceimpl.CompanyServiceImpl;
import com.cafebabe.phosphor.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
 * description:
 **/
@Controller
@CrossOrigin
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private final CompanyServiceImpl companyService;
    public CompanyController(CompanyServiceImpl companyService) { this.companyService = companyService; }

    @RequestMapping("company")
    @ResponseBody
    public JsonResponse getCompany(Integer companyId){
        Company company = companyService.getCompanyById(companyId);
        return new JsonResponse(200,"success",company);
    }

}
