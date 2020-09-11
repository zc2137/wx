package com.example.demo.mapping;

import com.example.demo.domain.Shop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IShopMapping {

    /**
     * 查询所以正在营业的店铺
     * @return
     */
    List<Shop> findAllShopByWork();
}
