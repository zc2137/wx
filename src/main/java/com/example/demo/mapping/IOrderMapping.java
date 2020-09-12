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
}
