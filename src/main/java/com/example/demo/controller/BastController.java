package com.example.demo.controller;

import com.example.demo.service.IOrderUserService;
import com.example.demo.service.IShopService;
import com.example.demo.service.ISystemService;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 基类控制器
 */
@Controller
public class BastController {

    @Autowired
    protected ISystemService systemService;

    @Autowired
    protected IShopService shopService;

    @Autowired
    protected IOrderUserService orderUserService;

    @Autowired
    protected IUserService userService;
}
