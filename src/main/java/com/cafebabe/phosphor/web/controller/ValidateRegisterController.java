package com.cafebabe.phosphor.web.controller;

import com.cafebabe.phosphor.model.entity.Parent;
import com.cafebabe.phosphor.model.entity.ValidateRegister;
import com.cafebabe.phosphor.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: ValidateRegisterController
 *
 * create_date: 2018/9/28
 *
 * create_time: 14:38
 *
 * description:
 **/


@CrossOrigin
@Controller
@RequestMapping("/validateRegister")
public class ValidateRegisterController {

    @Autowired(required = false)
    HttpServletRequest httpServletRequest;

//
//    public ValidateRegisterController(HttpServletRequest httpServletRequest) {
//        this.httpServletRequest = httpServletRequest;
//    }

    @RequestMapping("/parentValidateRegister")
    @ResponseBody
    public JsonResponse parentValidateRegister(@RequestBody ValidateRegister validateRegister){

        System.out.println(httpServletRequest.getSession().getAttribute("userLoginPhone"));
        return new JsonResponse(20000,"成功",1);
    }
}
