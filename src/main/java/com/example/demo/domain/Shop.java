package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 商铺的实体类对象
 */
public class Shop {

    private Long id;

    private String shopID;

    private String shopName;

    private String shopAddress;

    private String shopTelephone;

    //开始营业的时间
    private String beginOffice;
    //结束营业的时间
    private String overOffice;

    private char nowState;      //商铺当前的状态  （0 结束营业  1 正在营业）

    private String publicMessage;   //商铺公告

    private Integer startPrice;       //起送价格

    private Integer distributionTime;   //配送时间

    private String appriase;            //商家评价

    private String img;                 //商家图片

    private String type;                //商家类型

}
