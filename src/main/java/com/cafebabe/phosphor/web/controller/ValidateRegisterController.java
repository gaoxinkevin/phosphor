package com.cafebabe.phosphor.web.controller;

import com.cafebabe.phosphor.model.entity.Parent;
import com.cafebabe.phosphor.model.entity.ValidateRegister;
import com.cafebabe.phosphor.util.JsonResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/parentValidateRegister")
    @ResponseBody
    public JsonResponse parentValidateRegister(@RequestBody ValidateRegister validateRegister){

        return new JsonResponse(20000,"成功",1);
    }
}
