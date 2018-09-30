package com.cafebabe.phosphor.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: JsonResponse
 *
 * package:
 *
 * create_date: 2018/9/17
 *
 * create_time: 09:48
 *
 **/

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JsonResponse {

    private Integer code;
    private String  message;
    private Object  data;

    public enum Status{

        /**
         * 成功后返回code
         */
        SUCCESS(200,"ok");

        private Integer code;
        private String  message;
        Status(Integer code,String message){
            this.code=code;
            this.message=message;
        }

        public Integer getCode(){
            return code;
        }

        public String  getMessage(){
            return message;
        }
    }

}
