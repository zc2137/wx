package com.example.demo.service.impl;

import com.example.demo.domain.OrderUser;
import com.example.demo.service.IOrderUserService;
import com.example.demo.util.DateUtil;
import org.springframework.stereotype.Service;

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
}
