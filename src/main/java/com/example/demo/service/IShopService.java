package com.example.demo.service;

import com.example.demo.domain.Shop;
import com.example.demo.domain.SupermarketCommodity;

import java.util.List;

public interface IShopService {

    /**
     * 查找所有正在营业的店铺
     */
    List<Shop> findAllShopByWork();

    /**
     * 查询生活超市里面的所有的商品
     * @return
     */
    List<SupermarketCommodity> findAllShopBySUP();

    /**
     * 保存一件商品到生活超市之中
     * @param sup
     * @return
     */
    Integer saveShopSUP(SupermarketCommodity sup);

    /**
     * 下架生活超市中的一件商品
     * @param comID
     * @return
     */
    Integer pullShopSUP(String comID);
}
