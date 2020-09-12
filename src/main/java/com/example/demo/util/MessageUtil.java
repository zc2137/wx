package com.example.demo.util;

import com.example.demo.domain.Message;

/**
 * 返回前端消息的工具类
 */
public class MessageUtil {

    public static Message messageAuto(Integer code,String message,Object data){
        Message m = new Message();
        m.setCode( code );
        m.setMessage( message );
        m.setData( data );
        return m;
    }
}
