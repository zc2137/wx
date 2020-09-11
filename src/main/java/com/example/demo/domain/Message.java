package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回给前端的信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private Integer code;       //接口状态码

    private String message;     //接口消息

    private Object data;        //数据
}
