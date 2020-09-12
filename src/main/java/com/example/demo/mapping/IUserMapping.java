package com.example.demo.mapping;

import com.example.demo.domain.Staff;
import org.apache.ibatis.annotations.Mapper;

/**
 * 关于所以用户的mapping
 */
@Mapper
public interface IUserMapping {

    /**
     * 外送员的登录的方法
     * @return
     */
    Staff staffLogin(String username,String password);
}
