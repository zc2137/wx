package com.example.demo.service.impl;

import com.example.demo.domain.Shop;
import com.example.demo.service.IShopService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl extends BastService implements IShopService {

    @Override
    public List<Shop> findAllShopByWork() {
        return shopMapping.findAllShopByWork();
    }
}
