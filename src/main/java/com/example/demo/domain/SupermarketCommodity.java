package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupermarketCommodity {

    private Long id;

    private String comID;       //商品的ID

    private String name;        //商品的名称

    private String typeName;    //分类的名称

    private Short typeID;      //分类的ID

    private Double price;        //商品的价格

    private String img;         //商品图片的路径

    private String norms;       //商品的规格描述

    private Character nowState;     //商品当前的状态（0 下架  1上架）
}
