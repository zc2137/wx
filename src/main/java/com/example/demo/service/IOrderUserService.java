package com.example.demo.service;

import com.example.demo.domain.OrderUser;

import java.util.List;

/**
 * 用户订单的业务类
 */
public interface IOrderUserService {

    /**
     * 查询所有的跑腿，快递代取
     * @return
     */
    List<OrderUser> findAllOrderUser();

    /**
     * 外送员抢到订单到数据库保存的业务类
     * @param username      外送员的昵称
     * @param staffID       外送员的ID
     * @param orderID       订单的ID
     * @return
     */
    Integer staffSaveOrder(String username,String staffID,String orderID);

    /**
     * 用户创建代取快递的订单
     * @return
     */
    Integer creatUserOrder(OrderUser orderUser);

    /**
     * 根据订单的ID删除对应的订单信息
     * @param orderID
     * @return
     */
    Integer deleteUserOrder(String orderID);
}
