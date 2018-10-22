package com.cafebabe.phosphor.web.controller;


import com.cafebabe.phosphor.util.JsonResponse;
import com.cafebabe.phosphor.model.entity.UserLogin;
import com.cafebabe.phosphor.service.serviceimpl.UserLoginServiceImpl;


import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


/**
 * @author supersuntangao@gmail.com
 * <p>
 * class_name: UserLoginController
 * <p>
 * create_date: 2018/9/29
 * <p>
 * create_time: 09:52
 * <p>
 * description: 用户登录分发
 **/

@Controller
@CrossOrigin
@RequestMapping("/userLogin")
public class UserLoginController {


    private final UserLoginServiceImpl userLoginService;
    @Autowired(required = false)
    private HttpServletRequest httpServletRequest;

    @Autowired
    public UserLoginController(UserLoginServiceImpl userLoginService) {
        this.userLoginService = userLoginService;
    }

    @RequestMapping("userLogin")
    @ResponseBody
    public JsonResponse userLogin(@RequestBody UserLogin userLogin) {
        String password = userLogin.getUserLoginPwd();
        String loginPhone = userLogin.getUserLoginPhone();
        String result = userLoginService.getUserLoginService(loginPhone, password);
        if ("用户名密码正确".equals(result)) {
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("userLoginPhone", userLogin.getUserLoginPhone());
            return new JsonResponse(20000, "用户名密码正确", result);
        } else if ("用户名或密码不正确，请确认后登录".equals(result)) {
            return new JsonResponse(10000, "用户名或密码不正确，请确认后登录", result);
        } else {
            return new JsonResponse(30000, "未注册，失败", result);
        }
    }

    @PostMapping("updateUserLoginPwd")
    @ResponseBody
    public JsonResponse updateUserLoginPwd(@RequestBody UserLogin userLogin) {
        boolean result = userLoginService.updateUserLoginPasswordService(userLogin);
        if (result) {
            return new JsonResponse(20000, "修改密码成功", result);
        }
        return new JsonResponse(30000, "修改密码失败", result);
    }

    @PostMapping("getUserLoginPassword")
    @ResponseBody
    public JsonResponse getUserLoginPassword(){
        String userLoginPhone =  (String) httpServletRequest.getSession().getAttribute("userLoginPhone");
        return new JsonResponse(20000,"成功",userLoginService.getUserLoginPassword(userLoginPhone));
    }
}
