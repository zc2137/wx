package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用于页面的跳转
 */

@Controller
public class pageChange {

    @RequestMapping("/staff")
    public String pageChange(){
        return "test";
    }
}
