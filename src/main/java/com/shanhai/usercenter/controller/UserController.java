package com.shanhai.usercenter.controller;

import com.shanhai.usercenter.mapper.request.UserRegisterRequest;
import com.shanhai.usercenter.model.User;
import com.shanhai.usercenter.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @BelongsProject: user-center
 * @BelongsPackage: com.shanhai.usercenter.controller
 * @Description: 用户接口
 * @Author: hetianyou
 * @CreateTime: 2023-11-26  15:21:23
 * @Version: 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户注册
     * @author: hetianyou
     * @date: 2023/11/26 15:27
     * @param: userAccount
     * @param: userPassword
     * @param: checkPassword
     * @return: long
     **/
    @PostMapping("/register")
    public long userRegister(@RequestBody UserRegisterRequest request){
         return userService.userRegister(request.getUserAccount(), request.getUserPassword(), request.getCheckPassword());
    }

    /**
     * 用户登录
     * @author: hetianyou
     * @date: 2023/11/26 15:26
     * @param: userAccount
     * @param: userPassword
     * @param: request
     * @return: com.shanhai.usercenter.model.User
     **/
    @PostMapping("/login")
    public User doLogin(@RequestBody UserRegisterRequest userRegisterRequest,HttpServletRequest request){
        return userService.doLogin(userRegisterRequest.getUserAccount(), userRegisterRequest.getUserPassword(),request);
    }


}


