package com.shanhai.usercenter.service;

import com.shanhai.usercenter.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author shanhai
 * @description 针对表【user】的数据库操作Service
 * @createDate 2023-11-19 23:11:22
 */
public interface UserService extends IService<User> {

    /**
     * @Description 用户注册
     * @author hetianyou
     * @date 2023/12/4 22:57
     * @param userAccount 用户名称
     * @param userPassword 用户密码
     * @param checkPassword 校验密码
     * @return long
     **/
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * @Description 用户登录
     * @author hetianyou
     * @date 2023/12/4 22:56
     * @param userAccount
     * @param userPassword
     * @param request
     * @return com.shanhai.usercenter.model.User
     **/
    User doLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * @Description  用户脱敏
     * @author hetianyou
     * @date 2023/12/4 23:02
     * @param user
     * @return com.shanhai.usercenter.model.User
     **/
    User getSafetyUser(User user);
    /**
     * @Description 查询用户
     * @author hetianyou
     * @date 2023/12/4 23:04
     * @param userName
     * @return java.util.List<com.shanhai.usercenter.model.User>
     **/
    List<User> searchUser(String userName);
}
