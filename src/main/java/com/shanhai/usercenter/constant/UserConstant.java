package com.shanhai.usercenter.constant;

import lombok.Builder;

/**
 * @Description 常量接口
 * @Author hetianyou
 * @CreateTime 2023-12-04  21:51:02
 * @Version 1.0
 */
public interface UserConstant {
    /**
     * 用户登录态
     */
    String USER_LOGIN_STATE = "USERLoginState";
    /**
     * 盐值
     */
    String SALT = "shanhai";
    /**===============权限==============**/
    /**
     * 默认权限
     */
    int DEFAULT_T_ROLE = 0;
    /**
     * 管理员权限
     */
    int ADMIN_T_ROLE = 1;


}
