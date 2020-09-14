package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 快递代取的实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderUser {

    private Long id;

    private String orderID;     //快递代取的ID

    private String expressSeat;     //快递站的位置

    private Short expressID;        //快递站的ID（代号）

    private String takeCode;        //取件码

    private String harvestName;     //收件人的姓名

    private String harvestTelephone;    //收件人的电话号码

    private String place;           //配送的地点和位置

    private Double price;           //价格

    private String remarks;         //备注

    private Date time;              //下单的时间

    private Integer heat;           //热度

    private char nowState;          //当前订单的状态

    private Long staffID;           //配送员的ID

    private Long userID;            //用户的ID

    private String dateFormat;      //格式化的日期

    private String createUserID;       //创建该订单用户的ID
}
