package com.example.demo.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.example.demo.domain.Message;
import com.example.demo.domain.Shop;
import com.example.demo.domain.SupermarketCommodity;
import com.example.demo.util.CheckAdminPassword;
import com.example.demo.util.MessageUtil;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/shop")
@RestController
@Slf4j
public class ShopController extends BastController{

    @GetMapping("/findAll")
    public Message findAllShopByWork(){
        Message message = new Message();
        List<Shop> shops = shopService.findAllShopByWork();
        if(!(CollectionUtil.isEmpty( shops ))){
            //如果数据不为空
            message.setCode( 200 );
            message.setMessage( "success" );
            message.setData( shops );
        }else {
            message.setCode( 500 );
            message.setMessage( "数据为空" );
            message.setData( null );
        }
        return message;
    }

    /**
     * 查询生活超市的所有商品
     * @return
     */
    @GetMapping("/findAllSUP")
    public Message findShopBySup(){
        List<Object> shops = redisTemplate.opsForList().range( "shopSUP", 0, -1 );
        if((!CollectionUtil.isEmpty( shops ))){
            //如果在redis中查询到了数据
            logger.debug( shops.toString() );
            return MessageUtil.messageAuto( 200,"success",shops );
        }else {
            List<SupermarketCommodity> all = shopService.findAllShopBySUP();
            if((!CollectionUtil.isEmpty( all ))){
                //如果数据不为空
                //将数据存储到redis中
                Long shopSUP = redisTemplate.opsForList().leftPushAll( "shopSUP", all );
                return MessageUtil.messageAuto( 200,"success",all );
            }else {
                return MessageUtil.messageAuto( 400,"商品列表为空",all );
            }
        }
    }

    /**
     * 保存一件商品到生活超市之中
     * @return
     */
    @PostMapping("/saveSUP")
    public Message saveShopBySUP(

            @RequestParam(name = "username" ,required = true) String username,     //管理员的用户名
            @RequestParam(name = "password" ,required = true) String password,     //管理员的密码
            @RequestParam(name = "nowState" ,required = true) Character nowState,
            @RequestParam(name = "name" ,required = true) String name,
            @RequestParam(name = "typeName" ,required = true) String typeName,
            @RequestParam(name = "typeID" ,required = true) Short typeID,
            @RequestParam(name = "price" ,required = true) Double price,
            @RequestParam(name = "img" ,required = true) String img,
            @RequestParam(name = "norms" ,required = true) String norms
    ){
        //判断密码是否正确
        if(!(CheckAdminPassword.checkAP( redisTemplate,username,password ))){
            return MessageUtil.messageAuto( 400,"权限不足",null );
        }else {
            // 密码正确 创建对象，存储数据
            SupermarketCommodity sup = new SupermarketCommodity
                            (null,null,name,typeName,typeID,price,img,norms,nowState);
            Integer i = shopService.saveShopSUP( sup );
            if(i == 1){
                //添加成功
                return MessageUtil.messageAuto( 200,"success",null );
            }else {
                return MessageUtil.messageAuto( 400,"添加失败",null );
            }
        }
    }

    /**
     * 下架生活超市中的一件商品
     *
     * @return
     */
    @PostMapping("/pullSUP")
    public Message pullShopSUP(
            @RequestParam(name = "adminUsername" ,required = true) String username,     //管理员的用户名
            @RequestParam(name = "adminPassword" ,required = true) String password,     //管理员的密码
            @RequestParam(name = "comID" ,required = true) String comID
    ){
        if(CheckAdminPassword.checkAP( redisTemplate,username,password )){
            //密码正确
            Integer i = shopService.pullShopSUP( comID );
            if(i ==1)
                return MessageUtil.messageAuto( 200,"success",null );
            else
                return MessageUtil.messageAuto( 400,"修改失败",null );
        }else{
            return MessageUtil.messageAuto( 400,"权限不足",null );
        }
    }
}
