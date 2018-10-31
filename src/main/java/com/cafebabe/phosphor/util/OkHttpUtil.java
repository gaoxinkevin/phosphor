package com.cafebabe.phosphor.util;

import com.google.gson.Gson;
import okhttp3.*;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author supersuntangao@gmail.com
 * <p>
 * class_name: OkHttpUtil
 * <p>
 * create_date: 2018/10/10
 * s
 * create_time: 23:53
 * <p>
 * description: 封装OkHttpUtil
 **/

@SuppressWarnings("unused")
public final class OkHttpUtil {

    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static String url;
    private static Map<String, String> params;


    public static String getSync(String url) {
        final Request request = new Request.Builder().url(url).build();
        Response response;
        try {
            response = okHttpClient.newCall(request).execute();
            if (null != response) {
                if (response.body() != null) {
                    return response.body().toString();
                } else {
                    return "服务器相应失效";
                }
            } else {
                return "服务器无响应";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "服务器无响应";
        }
    }

    static String postSync(String url, Map<String, String> params) {
        // RequestBody
        RequestBody requestBody;
        if (params == null) {
            params = new HashMap<>(1);
        }
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> map : params.entrySet()) {
            String key = map.getKey();
            String value;
            if (map.getValue() == null) {
                value = "";
            } else {
                value = map.getValue();
            }
            builder.add(key, value);
        }
        requestBody = builder.build();
        // 创建一个Request
        final Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        final Response response;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.code() != HttpStatus.OK.value()) {
                Gson gson = new Gson();
                assert response.body() != null;
                return (String) gson.fromJson(response.body().string(), Map.class).get("error_code");
            } else {
                if (null !=response.body()){
                return response.body().string();
                }else {
                    return "服务器错误";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "服务器超时相应";
        }
    }
}
