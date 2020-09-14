package com.example.demo.mapping;

import com.example.demo.domain.OrderUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IOrderMapping {

    /**
     * 查询所有快递代取的订单
     * @return
     */
    List<OrderUser> findAllOrderUser();

    /**
     * 外送员抢到订单
     * @return
     */
    Integer staffSaveOrder(String username,String staffID,String orderID);

    /**
     * 创建代取快递的任务的方法
     * @return
     */
    Integer createOrderUser(OrderUser orderUser);
}
