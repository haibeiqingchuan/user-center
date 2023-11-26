package com.shanhai.usercenter.mapper.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @BelongsProject: user-center
 * @BelongsPackage: com.shanhai.usercenter.mapper.request
 * @Description: TODO
 * @Author: hetianyou
 * @CreateTime: 2023-11-26  16:19:11
 * @Version: 1.0
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = -346134804679293377L;

    private String userAccount;
    private String userPassword;
    private String checkPassword;
}


