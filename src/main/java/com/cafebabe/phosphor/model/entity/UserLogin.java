package com.cafebabe.phosphor.model.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * user_login
 * @author 
 */

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class UserLogin implements Serializable {
    /**
     * 登录ID
     */
    private Integer userLoginId;

    /**
     * 登录用户名
     */
    private String userLoginPhone;

    /**
     * 登录密码
     */
    private String userLoginPwd;

    /**
     * 登录状态
     */
    private Integer userLoginStatus;

    /**
     * 最后一次登录时间
     */
    private Date userLoginTime;

    private String userLoginSf;

    private static final long serialVersionUID = 1L;

}