package com.shanhai.usercenter.service;

import com.shanhai.usercenter.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shanhai
 * @description 针对表【user】的数据库操作Service
 * @createDate 2023-11-19 23:11:22
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册
     *
     * @author: shanhai
     * @date: 2023/11/20 23:10
     * @param: userAccount 用户账号
     * @param: userPassword 用户密码
     * @param: checkPassword 校验密码
     * @return: long
     **/
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * 用户登录
     * @author: hetianyou
     * @date: 2023/11/21 22:41
     * @param: userAccount 账户名
     * @param: userPassword 密码
     * @return: com.shanhai.usercenter.model.User
     **/
    User doLogin(String userAccount, String userPassword, HttpServletRequest request);

}
