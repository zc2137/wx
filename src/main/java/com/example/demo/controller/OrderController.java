package com.example.demo.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.example.demo.domain.Message;
import com.example.demo.domain.OrderUser;
import com.example.demo.service.impl.BastService;
import com.example.demo.util.MessageUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/order")
@RestController
public class OrderController extends BastController {

    @GetMapping("/getAllOrderUser")
    public Message getAllOrderUser(){
        List<OrderUser> orders = orderUserService.findAllOrderUser();
        if(!(CollectionUtil.isEmpty( orders ))){
            //如果数据不为空
            return MessageUtil.messageAuto( 200,"success",orders );
        }else {
            return MessageUtil.messageAuto( 500,"数据为空",orders );
        }

    }
}
