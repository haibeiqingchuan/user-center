package com.shanhai.usercenter.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shanhai.usercenter.constant.UserConstant;
import com.shanhai.usercenter.mapper.request.UserRegisterRequest;
import com.shanhai.usercenter.model.User;
import com.shanhai.usercenter.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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
     * @Description  用户注册
     * @author hetianyou
     * @date 2023/12/4 23:10
     * @param request
     * @return long
     **/
    @PostMapping("/register")
    public long userRegister(@RequestBody UserRegisterRequest request){
         return userService.userRegister(request.getUserAccount(), request.getUserPassword(), request.getCheckPassword());
    }

    /**
     * @Description 用户登录
     * @author hetianyou
     * @date 2023/12/4 23:10
     * @param userRegisterRequest
     * @param request
     * @return com.shanhai.usercenter.model.User
     **/
    @PostMapping("/login")
    public User doLogin(@RequestBody UserRegisterRequest userRegisterRequest,HttpServletRequest request){
        return userService.doLogin(userRegisterRequest.getUserAccount(), userRegisterRequest.getUserPassword(),request);
    }

    /**
     * @Description 查询用户
     * @author hetianyou
     * @date 2023/12/2 20:34
     * @param userName
     * @return java.util.List<com.shanhai.usercenter.model.User>
     **/
    @GetMapping("/searchUser")
    public List<User> searchUser(String userName,HttpServletRequest request){
        if(!isAdmin(request)){
            return new ArrayList<>();
        }
        return userService.searchUser(userName);
    }
    /**
     * @Description 是否管理员
     * @author hetianyou
     * @date 2023/12/4 22:37
     * @param request
     * @return boolean
     **/
    private boolean isAdmin(HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute(UserConstant.USER_LOGIN_STATE);
        return user != null && user.getUserRole() == UserConstant.ADMIN_T_ROLE;
    }

    /**
     * @Description 删除用户
     * @author hetianyou
     * @date 2023/12/2 20:36
     * @param id
     * @return boolean
     **/
    @PostMapping("/delete")
    public boolean deleteUser(@RequestBody long id,HttpServletRequest request){
        if(!isAdmin(request)){
            return false;
        }
        if(id <= 0){
            return false;
        }
        return userService.removeById(id);
    }

}


