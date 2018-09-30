package com.cafebabe.phosphor.web.controller;

import com.cafebabe.phosphor.model.entity.Parent;
import com.cafebabe.phosphor.model.entity.UserLogin;
import com.cafebabe.phosphor.service.serviceimpl.UserLoginServiceImpl;
import com.cafebabe.phosphor.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: UserLoginController
 *
 * create_date: 2018/9/29
 *
 * create_time: 09:52
 *
 * description: 用户登录分发
 **/

@Controller
@CrossOrigin
@RequestMapping("/userLogin")
public class UserLoginController {

    @Autowired
    private final UserLoginServiceImpl userLoginService;

    public UserLoginController(UserLoginServiceImpl userLoginService) {
        this.userLoginService = userLoginService;
    }

    @RequestMapping("userLogin")
    @ResponseBody
    public JsonResponse userLogin(@RequestBody UserLogin userLogin){
        String password = userLogin.getUserLoginPwd();
        String loginPhone = userLogin.getUserLoginPhone();
        String result = userLoginService.getUserLoginService(loginPhone,password);
        if ("用户名密码正确".equals(result)){
            return new JsonResponse(20000,"用户名密码正确",result);
        }else if ("用户名或密码不正确，请确认后登录".equals(result)){
            return new JsonResponse(10000,"用户名或密码不正确，请确认后登录",result);
        }else {
            return new JsonResponse(30000,"未注册，失败",result);
        }
    }
}
