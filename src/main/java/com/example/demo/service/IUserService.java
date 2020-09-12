package com.example.demo.service;

import com.example.demo.domain.Staff;

/**
 * 关于用户的业务类
 */
public interface IUserService {

    /**
     * 外送员的登录方法
     * @return
     */
    Staff staffLogin(String username,String password);
}
