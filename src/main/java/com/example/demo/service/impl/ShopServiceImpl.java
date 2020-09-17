package com.example.demo.service.impl;

import cn.hutool.core.lang.ObjectId;
import com.example.demo.domain.Shop;
import com.example.demo.domain.SupermarketCommodity;
import com.example.demo.service.IShopService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl extends BastService implements IShopService {

    @Override
    public List<Shop> findAllShopByWork() {
        return shopMapping.findAllShopByWork();
    }

    @Override
    public List<SupermarketCommodity> findAllShopBySUP() {
        return shopMapping.findAllBySup();
    }

    @Override
    public Integer saveShopSUP(SupermarketCommodity sup) {
        //设置参数
        sup.setComID( ObjectId.next().substring( 0,10 ) );  //设置商品的ID
        Integer i = shopMapping.saveShopSUP( sup );
        if(i==1){
            //代表商品上架成功    更新redis中的key
            Boolean bool = redisTemplate.delete( "shopSUP" );
        }
        return i;
    }

    @Override
    public Integer pullShopSUP(String comID) {
        Integer i = shopMapping.pullShopSUP( comID );
        if(i==1){
            //代表商品上架成功    更新redis中的key
            Boolean bool = redisTemplate.delete( "shopSUP" );
        }
        return i;
    }
}
