package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 商品类的实例化对象
 */
public class Commodity {
    private Long id;

    private String commodityID;     //商品的ID

    private String img;             //商品的图片地址

    private String commodityName;   //商品的名称

    private Short commodityPrice;    //商品的起送价格

    private Short distributionPrice;    //商品的配送价格

    private Short soldNum;          //商品的卖出数量

    private Short goodReviewNum;  //好评数量

    private String commodityDescribe;      //商品描述

    private Short packMoney;        //打包价格

    private Short heat;     //商品热度

    private String shopID;  //店铺的ID

}
