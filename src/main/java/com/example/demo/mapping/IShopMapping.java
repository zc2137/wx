package com.example.demo.mapping;

import com.example.demo.domain.Shop;
import com.example.demo.domain.SupermarketCommodity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IShopMapping {

    /**
     * 查询所以正在营业的店铺
     * @return
     */
    List<Shop> findAllShopByWork();

    /**
     * 查询生活超市中的所有商品
     * @return
     */
    List<SupermarketCommodity> findAllBySup();

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
