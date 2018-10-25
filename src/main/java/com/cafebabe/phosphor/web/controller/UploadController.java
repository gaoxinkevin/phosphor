package com.cafebabe.phosphor.web.controller;

import com.cafebabe.phosphor.service.serviceimpl.ParentServiceImpl;

import com.google.gson.Gson;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: UploadController
 *
 * create_date: 2018/10/17
 *
 * create_time: 02:59
 *
 * description: 图片上传
 **/

@Controller
@CrossOrigin
@RequestMapping("upload")
public class UploadController {

     private final HttpServletRequest httpServletRequest;
     private final ParentServiceImpl parentService;
     private final static String HTTP_QINIU  = "http://pg8h1ukn9.bkt.clouddn.com/";

     @Autowired
     public UploadController(HttpServletRequest httpServletRequest, ParentServiceImpl parentService) {
         this.httpServletRequest = httpServletRequest;
         this.parentService = parentService;
     }

    private String uploadAvatar(String fileName){
        Configuration cfg = new Configuration(Zone.zone0());
        UploadManager uploadManager = new UploadManager(cfg);
        String accessKey = "1_ejbRfHFAIVg0Mj-SpiB8NQTJHbkTdTg3L-KmAY";
        String secretKey = "oAjG6AtZFnozMS0Cy6Hg8MD7Uk9D7A54LCe8LrZW";
        String bucket = "phosphor";
        System.out.println("fileName"+fileName);
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(fileName, null, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
            return putRet.hash;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return "error";
    }


    @RequestMapping("fileupload.do")
    @ResponseBody
    public String upload(@RequestBody MultipartFile file) throws IOException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
        String res = sdf.format(new Date());
        String parentPhone = (String) httpServletRequest.getSession().getAttribute("userLoginPhone");
        // uploads文件夹位置
        String rootPath = httpServletRequest.getSession().getServletContext().getRealPath("resource/uploads/");
        // 原始名称
        String originalFileName = file.getOriginalFilename();
        // 新文件名
        String newFileName = "sliver" + res + originalFileName.substring(originalFileName.lastIndexOf("."));
        // 创建年月文件夹
        Calendar date = Calendar.getInstance();
        File dateDirs = new File(date.get(Calendar.YEAR) + File.separator + (date.get(Calendar.MONTH)+1));

        // 新文件
        File newFile = new File(rootPath + File.separator + dateDirs + File.separator + newFileName);
        // 判断目标文件所在目录是否存在

        if( !newFile.getParentFile().exists()) {
            // 如果目标文件所在的目录不存在，则创建父目录
            //noinspection ResultOfMethodCallIgnored
            newFile.getParentFile().mkdirs();
        }
        file.transferTo(newFile);
        // 完整的url
        String fileUrl = date.get(Calendar.YEAR) + "/" + (date.get(Calendar.MONTH)+1) + "/" + newFileName;
        uploadAvatar(rootPath+fileUrl);
        String parentPhotoHash = uploadAvatar(rootPath+fileUrl);
        parentService.updateParentImg(HTTP_QINIU+parentPhotoHash,parentPhone);
        return uploadAvatar(rootPath+fileUrl);
    }
}
