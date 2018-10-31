package com.cafebabe.phosphor.service.serviceImpl;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.junit.Test;

public class testController {
    @Test
    public void upload(){
        Configuration cfg = new Configuration(Zone.zone0());
//...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
//...生成上传凭证，然后准备上传
        String accessKey = "1_ejbRfHFAIVg0Mj-SpiB8NQTJHbkTdTg3L-KmAY";
        String secretKey = "oAjG6AtZFnozMS0Cy6Hg8MD7Uk9D7A54LCe8LrZW";
        String bucket = "phosphor";
//如果是Windows情况下，格式是 D:\\qiniu\\test.png
        String localFilePath = "/Users/tigerwhale/Projects/phosphor/target/phosphor/resource/uploads/2018/10/sliver20181017135400914.jpeg";
//默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = null;
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(localFilePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
    }
}
