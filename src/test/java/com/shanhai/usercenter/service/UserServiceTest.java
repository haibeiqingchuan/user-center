package com.shanhai.usercenter.service;
import java.util.Date;

import com.shanhai.usercenter.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.annotation.Resource;
/**
 * @description: 用户服务测试
 * @author: hetianyou
 * @date: 2023/11/19 23:18
 * @Version: 1.0
 **/
@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testAddUser(){
        User user = new User();
        user.setId(0L);
        user.setUserAccount("hty");
        user.setUserPassword("");
        user.setUserName("天佑");
        user.setGender(0);
        user.setPhone("17340031319");
        user.setAvatarUrl("");
        user.setEmail("");
        user.setUserStatus(0);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setIsDelete(0);
        boolean result = userService.save(user);
        System.out.println(user.getId());
        Assert.isTrue(result,"插入成功");
    }

    @Test
    void userRegister() {
        String userAccount = "shanhai";
        String userPassword = "";
        String checkPassword = "123456";
        long result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1,result);
        userAccount = "sh";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1,result);
        userPassword = "123456";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1,result);
        userAccount = "s h";
        userPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1,result);
        checkPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1,result);
        userAccount = "shanhai";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1,result);
        Assertions.assertTrue(result < 0);
    }

    @Test
    void doLogin() {
        String accountName = "shanhai";
        String passWord = "12345678";
        User user = userService.doLogin(accountName, passWord, null);
        Assertions.assertTrue(user != null);
    }
}