package com.cafebabe.phosphor.service.serviceimpl;

import com.cafebabe.phosphor.dao.UserLoginDAO;
import com.cafebabe.phosphor.model.entity.UserLogin;
import com.cafebabe.phosphor.service.UserLoginService;
import com.cafebabe.phosphor.util.RedisUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author supersuntangao@gmail.com
 * <p>
 * class_name: UserLoginServiceImpl
 * <p>
 * create_date: 2018/9/30
 * <p>
 * create_time: 08:49
 * <p>
 * description: 验证用户名的service实现类
 **/

@Service
public class UserLoginServiceImpl implements UserLoginService {

    private final UserLoginDAO userLoginDAO;

    @Autowired
    public UserLoginServiceImpl(UserLoginDAO userLoginDAO) {
        this.userLoginDAO = userLoginDAO;
    }

    @Override
    public String getUserLoginService(String userLoginPhone, String userPassword) {
        UserLogin result = RedisUtil.getObj(userLoginPhone + "login", UserLogin.class);
        if (null != result) {
            //用户登录过缓存中有这个用户
            if (userPassword.equals(result.getUserLoginPwd())){
                return "用户名密码正确";
            }else {
                return "用户名或密码不正确，请确认后登录";
            }
        } else {
            UserLogin userLogin = userLoginDAO.getUserLoginDao(userLoginPhone);
            if (null != userLogin){
                if (userPassword.equals(userLogin.getUserLoginPwd())){
                    RedisUtil.set(userLoginPhone+"login",userLogin);
                    return "用户名密码正确";
                }else {
                    return "用户名或密码不正确，请确认后登录";
                }
            }else {
                return "用户名不存在";
            }
        }
    }

    @Override
    public boolean updateUserLoginPasswordService(UserLogin userLogin) {
        RedisUtil.del(userLogin.getUserLoginPhone() + "login",userLogin.getUserLoginPhone()+"loginPassword");
        return userLoginDAO.updateParentPasswordDao(userLogin);
    }

    public String getUserLoginPassword(String userLoginPhone) {
        String result = RedisUtil.getString(userLoginPhone+"loginPassword");
        if (null != result){
            return result;
        }else {
            String password = userLoginDAO.getUserLoginDao(userLoginPhone).getUserLoginPwd();
            RedisUtil.setString(userLoginPhone+"loginPassword",password);
            return password;
        }
    }
}
