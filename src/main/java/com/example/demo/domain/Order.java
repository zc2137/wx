package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Long id;

    private String orderID; //订单id

    private Data beginTime;     //开始配送的时间

    private String payType;     //当前订单支付的类型

    private String distributionAddress;     //配送地址

    private Double payMoney;        //当前订单的价格

    private char nowState;          //当前状态 (0 代表配送完成  1 代表正在配送  2  代表用户取消)

    private String distributionUsername;    //用户名称

    private String distributionTelephone;       //配送的用户电话

    private String shopID;      //店铺的ID

    private String commodityID;     //商品的ID
}
