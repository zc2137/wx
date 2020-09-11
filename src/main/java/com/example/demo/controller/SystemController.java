package com.example.demo.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.example.demo.domain.Message;
import com.example.demo.domain.SystemSwap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SystemController extends BastController {

    @GetMapping("/systemSwap")
    public Message findAllSystemSwap(){
        List<SystemSwap> swap = systemService.findAllSwap();
        Message message = new Message();
        if (!(CollectionUtil.isEmpty( swap ))){
            //如果列表数据不为空
            message.setCode( 200 );
            message.setMessage( "success" );
            message.setData( swap );
        }else {
            message.setCode( 500 );
            message.setMessage( "数据为空" );
            message.setData( swap );
        }
        return message;
    }

}
