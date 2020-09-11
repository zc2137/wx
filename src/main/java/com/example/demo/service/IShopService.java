package com.example.demo.service;

import com.example.demo.domain.Shop;

import java.util.List;

public interface IShopService {

    /**
     * 查找所有正在营业的店铺
     */
    List<Shop> findAllShopByWork();
}
