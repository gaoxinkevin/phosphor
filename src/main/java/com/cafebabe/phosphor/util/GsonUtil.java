package com.cafebabe.phosphor.util;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: GsonUtil
 *
 * create_date: 2018/10/25
 *
 * create_time: 09:21
 *
 * description: Gson 转换
 **/

@SuppressWarnings("unused")
public class GsonUtil<T> {

    private static Gson gson;

    static {
        gson = new Gson();
    }

    private GsonUtil() {
    }

    /**
     * 将object对象转成json字符串
     *  @param object 任意类型
     *  @return 转换为String类型
     */
    public static String gsonToString(Object object) {
        String gsonString = null;
        if (gson != null) {
            gsonString = gson.toJson(object);
        }
        return gsonString;
    }

    /**
     * 将gsonString转成泛型bean
     * @param gsonString string类型
     * @param cls 类类型
     * @return  转换为java bean
     */
    public static <T> T gsonToBean(String gsonString, Class<T> cls) {
        T t = null;
        if (gson != null) {
            t = gson.fromJson(gsonString, cls);
        }
        return t;
    }

    /**
     * 转成list
     *  泛型在编译期类型被擦除导致报错
     * @param gsonString string类型
     * @param cls 类类型
     * @return 转换为数组类型
     */
    public static <T> List<T> gsonToList(String gsonString, Class<T> cls) {
        List<T> list = null;
        if (gson != null) {
            list = gson.fromJson(gsonString, new TypeToken<List<T>>() {
            }.getType());
        }
        return list;
    }

    /**
     * 转成list
     * 解决泛型问题
     * @param json string 类型
     * @param cls 类  类型
     * @param <T> 类  泛型
     * @return list类型
     */
    public static <T> List<T> jsonToList(String json, Class<T> cls) {
        Gson gson = new Gson();
        List<T> list = new ArrayList<>();
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        for (final JsonElement elem : array) {
            list.add(gson.fromJson(elem, cls));
        }
        return list;
    }

    /**
     * 转成list中有map的
     * @param gsonString stirng类型
     * @return list类型
     */
    public static <T> List<Map<String, T>> gsonToListMaps(String gsonString) {
        List<Map<String, T>> list = null;
        if (gson != null) {
            list = gson.fromJson(gsonString, new TypeToken<List<Map<String, T>>>() {
            }.getType());
        }
        return list;
    }

    /**
     * 转成map的
     * @param gsonString 传入string 类型
     * @return map类型
     */
    public static <T> Map<String, T> gsonToMaps(String gsonString) {
        Map<String, T> map = null;
        if (gson != null) {
            map = gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {
            }.getType());
        }
        return map;
    }



}
