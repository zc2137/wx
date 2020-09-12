package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 外送，快递员的实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Staff {

    private Long id;

    private String staffID;     //快递员的ID

    private String staffName;      //快递员的姓名

    private String staffTelephone;  //快递员的电话

    private String username;        //外送的用户名

    private String password;        //外送的密码

    private Character nowState;     //当前账号的状态（0 代表异常  1 代表正常）

    private Double goodReview;      //好评数量

    private char isRealName;        //是否实名

}
