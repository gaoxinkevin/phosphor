package com.cafebabe.phosphor.web.controller;


import java.io.IOException;

import java.util.List;
import java.util.ArrayList;

import com.cafebabe.phosphor.model.entity.Parent;
import com.cafebabe.phosphor.service.serviceimpl.ParentServiceImpl;

import com.cafebabe.phosphor.util.JsonResponse;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.apache.http.HttpStatus;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.entity.UrlEncodedFormEntity;

import javax.servlet.http.HttpServletRequest;


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

    @Autowired
    public ParentController(ParentServiceImpl parentService) {
        this.parentService = parentService;
    }

    @Autowired
    HttpServletRequest httpServletRequest;

    @SuppressWarnings("all")
    @RequestMapping("parentRegister")
    public Integer parentRegister(@RequestBody Parent parent) throws IOException {
        final String url = "http://api.sendcloud.net/apiv2/mail/send";
        final String apiUser = "CAFEBABE";
        final String apiKey = "HF1QU5kKsnzdXMYx";
        final String toEmail=parent.getParentMail();
        final String formEmail = "tigerwhale@superunique.ooo";

        HttpClient httpclient = HttpClientBuilder.create().build();
        HttpPost httPost = new HttpPost(url);

        System.out.println(toEmail);

        List params = new ArrayList();
        params.add(new BasicNameValuePair("apiUser", apiUser));
        params.add(new BasicNameValuePair("apiKey", apiKey));
        params.add(new BasicNameValuePair("from", formEmail));
        params.add(new BasicNameValuePair("fromName", "CAFEBABE"));
        params.add(new BasicNameValuePair("to", toEmail));
        params.add(new BasicNameValuePair("subject", "来自SendCloud的第一封邮件！"));
        params.add(new BasicNameValuePair("html", "你太棒了！你已成功的从SendCloud发送了一封测试邮件，接下来快登录前台去完善账户信息吧！"));
        httPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        HttpResponse response = httpclient.execute(httPost);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        } else {
            System.err.println("error");
        }
        httPost.releaseConnection();
        return parentService.insertParentService(parent.getParentMail());
    }

    @ResponseBody
    @PostMapping("parentImgUrl")
    public JsonResponse parentImgUrl(Gson parentPhone){
        String a = parentPhone.toString();

        System.out.println(a);
        String parentImgUrl =  parentService.getParentImgUrlService(a);
        return new JsonResponse(20000,"成功",parentImgUrl);
    }
}
