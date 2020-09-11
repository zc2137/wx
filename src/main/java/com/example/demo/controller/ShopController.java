package com.example.demo.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.example.demo.domain.Message;
import com.example.demo.domain.Shop;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ShopController extends BastController{

    @GetMapping("/shop/findAll")
    public Message findAllShopByWork(){
        Message message = new Message();
        List<Shop> shops = shopService.findAllShopByWork();
        if(!(CollectionUtil.isEmpty( shops ))){
            //如果数据不为空
            message.setCode( 200 );
            message.setMessage( "success" );
            message.setData( shops );
        }else {
            message.setCode( 500 );
            message.setMessage( "数据为空" );
            message.setData( null );
        }
        return message;
    }
}
