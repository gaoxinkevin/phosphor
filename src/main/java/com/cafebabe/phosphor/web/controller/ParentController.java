package com.cafebabe.phosphor.web.controller;


import com.cafebabe.phosphor.model.dto.MobileAndRandomCode;
import com.cafebabe.phosphor.model.entity.Parent;
import com.cafebabe.phosphor.service.serviceimpl.ParentServiceImpl;
import com.cafebabe.phosphor.util.GsonUtil;
import com.cafebabe.phosphor.util.JsonResponse;

import com.cafebabe.phosphor.util.SMSUtil;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.Map;




/**
 * @author supersuntangao@gmail.com
 * <p>
 * class_name: ParentController
 * <p>
 * create_date: 2018/9/27
 * <p>
 * create_time: 15:28
 * <p>
 * description: 家长控制模块
 **/

@Controller
@CrossOrigin
@RequestMapping("/parent")
public class ParentController {

    private final ParentServiceImpl parentService;
    private final HttpServletRequest httpServletRequest;
    private static final String TRUE_RESULT = "true";
    private static final String FALSE_RESULT = "false";

    /**
     * 短信接口相关
     */
    @Autowired
    public ParentController(ParentServiceImpl parentService, HttpServletRequest httpServletRequest) {
        this.parentService = parentService;
        this.httpServletRequest = httpServletRequest;
    }

    @ResponseBody
    @PostMapping("isParentExistByParentPhone")
    public JsonResponse isParentExistByParentPhone(@RequestBody Parent parentPhoneJson){
        String parentPhone = parentPhoneJson.getParentPhone();
        String isParentExitResult = parentService.getParentByParentPhoneService(parentPhone);
        if (TRUE_RESULT.equals(isParentExitResult)){
            return new JsonResponse(20000,"成功，获取用户成功",TRUE_RESULT);
        }
        if (FALSE_RESULT.equals(isParentExitResult)){
            return new JsonResponse(30000,"失败，用户没有注册",FALSE_RESULT);
        }
        return new JsonResponse(40000,"其他错误，请重新申请",FALSE_RESULT);
    }

    @SuppressWarnings("all")
    @ResponseBody
    @PostMapping("/verificationCode")
    public JsonResponse getVerCode(@RequestBody MobileAndRandomCode mobile){
        String result = SMSUtil.sendVerCode(mobile.getMobile(),mobile.getRandomCode());
        Map map=GsonUtil.GsonToMaps(result);
        return new JsonResponse(20000,"成功",map);
    }


    @ResponseBody
    @PostMapping("parentImgUrl")
    public JsonResponse parentImgUrl(){
        String parentPhone = (String) httpServletRequest.getSession().getAttribute("userLoginPhone");
        String parentImgUrl =  parentService.getParentImgUrlService(parentPhone);
        return new JsonResponse(20000,"成功",parentImgUrl);
    }

    @ResponseBody
    @RequestMapping("isSessionExit")
    public JsonResponse isSessionExit(){
        String parentPhone = (String) httpServletRequest.getSession().getAttribute("userLoginPhone");
        if (parentPhone!=null){
            return new JsonResponse(20000,"成功",parentPhone);
        }else {
            return new JsonResponse(30000,"session不存在",null);
        }
    }
}
