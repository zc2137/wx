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
}
