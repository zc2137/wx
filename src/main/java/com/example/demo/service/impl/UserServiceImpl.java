package com.example.demo.service.impl;

import com.example.demo.domain.Staff;
import com.example.demo.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BastService implements IUserService {

    @Override
    public Staff staffLogin(String username,String password) {
        return userMapping.staffLogin(username,password);
    }
}
