package com.cafebabe.phosphor.service.serviceImpl;


import com.google.gson.Gson;
import okhttp3.*;
import org.junit.Test;

import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.Map;

public class testValidateRegisterService {


    @Test
    public void testSend() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://v.juhe.cn/sms/send?mobile=13009837079&tpl_id=106235&tpl_value=%23code%23%3D2333&dtype=json&key=37181fb763ecbddfa20e11c898bf2ff8").get().build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }

    private final String T_VALUE_NAME = "tpl_value";

    @Test
    public void testPostSend()  {
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new  FormBody.Builder().add("mobile","13054208009").add("tpl_id","106235")
                .add(T_VALUE_NAME,"#code#=23334").add("dtype","json").add("key","37181fb763ecbddfa20e11c898bf2ff8").build();
        Request request  = new Request.Builder().url("http://v.juhe.cn/sms/send").post(requestBody).build();
       final Response response;
        try {
            response = client.newCall(request).execute();
            if (response !=  null) {
                if (response.code() != HttpStatus.OK.value()) {
                    Gson gson  = new Gson();
                    assert response.body() != null;
                    System.out.println(response.body().string());
                    gson.fromJson(response.body().string(), Map.class).get("error_code");
                }else {
                    System.out.println(response.body().string());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
