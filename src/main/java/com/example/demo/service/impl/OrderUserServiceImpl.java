package com.example.demo.service.impl;

import cn.hutool.core.lang.ObjectId;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;
import com.example.demo.domain.OrderUser;
import com.example.demo.mapping.IOrderMapping;
import com.example.demo.service.IOrderUserService;
import com.example.demo.util.DateUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderUserServiceImpl extends BastService implements IOrderUserService {
    @Override
    public List<OrderUser> findAllOrderUser() {

        List<OrderUser> all = orderMapping.findAllOrderUser();
        for (OrderUser orderUser:all) {
            orderUser.setDateFormat( DateUtil.DateChange( orderUser.getTime() ));
        }
        return all;
    }

    @Override
    public Integer staffSaveOrder(String username, String staffID, String orderID) {

        return orderMapping.staffSaveOrder( username,staffID,orderID );
    }

    @Override
    public Integer creatUserOrder(OrderUser orderUser) {

        //设置orderUser需要的各项参数
        orderUser.setTime( new Date() );
        orderUser.setOrderID( ObjectId.next().substring( 0,10 ) );
        orderUser.setPrice( 10.0D );
        orderUser.setHeat( 2 );
        orderUser.setNowState( '0' );

        Integer i = orderMapping.createOrderUser( orderUser );

        if(i==1){
            //添加缓存到redis中
            redisTemplate.opsForValue().set( orderUser.getOrderID(),new Integer( 0 ) );
        }
        return i;
    }
}
