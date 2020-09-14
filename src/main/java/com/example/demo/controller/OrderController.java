package com.example.demo.controller;


import cn.hutool.core.collection.CollectionUtil;
import com.example.demo.domain.Message;
import com.example.demo.domain.OrderUser;
import com.example.demo.util.MessageUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/order")
@RestController
public class OrderController extends BastController {

    @GetMapping("/getAllOrderUser")
    public Message getAllOrderUser(){
        List<OrderUser> orders = orderUserService.findAllOrderUser();
        if(!(CollectionUtil.isEmpty( orders ))){
            //如果数据不为空
            return MessageUtil.messageAuto( 200,"success",orders );
        }else {
            return MessageUtil.messageAuto( 500,"数据为空",orders );
        }
    }

    //该方法需加入同步锁
    synchronized
    @PostMapping("/staffSave")
    public Message staffSaveOrder(@RequestParam(name = "staffID" ,required = true) String staffID,
                                  @RequestParam(name = "username" ,required = true) String username,
                                  @RequestParam(name = "orderID" ,required = true) String orderID,
                                  @RequestParam(name = "nowState" ,required = true) Integer nowState
                                  ){
        if(nowState == 0){
            //当前外送员账号状态异常
            return MessageUtil.messageAuto(400,"账号异常",null);
        }
        else {
            //如果账号状态正常,根据订单ID拿到对应的当前订单的状态
            Integer o =(Integer) redisTemplate.opsForValue().get( orderID );

            if(o!=null && o!=1){
                //订单状态为0,代表没人抢单
                //更新redis key
                redisTemplate.opsForValue().set( orderID,new Integer( 1 ) );
                //调用方法
                Integer sql=orderUserService.staffSaveOrder( username, staffID, orderID );

                return MessageUtil.messageAuto(200,"抢单成功",null);
            }
            else {
                return MessageUtil.messageAuto(400,"抱歉，你来晚了，该订单已经被抢购",null);
            }
        }
    }

    /**
     * 创建跑腿订单
     * @return
     */
    @PostMapping("/creatStaffOrder")
    public Message creatStaffOrder(
            @RequestParam(name = "expressSeat" ,required = true) String expressSeat,
            @RequestParam(name = "expressID" ,required = true) Short expressID,
            @RequestParam(name = "takeCode" ,required = true) String takeCode,
            @RequestParam(name = "harvestName" ,required = true) String harvestName,
            @RequestParam(name = "harvestTelephone" ,required = true) String harvestTelephone,
            @RequestParam(name = "place" ,required = true) String place,
            @RequestParam(name = "remarks" ,required = true) String remarks,
            @RequestParam(name = "createUserID" ,required = true) String createUserID
    ){

        //创建对象
        OrderUser orderUser = new OrderUser();

        orderUser.setExpressSeat( expressSeat );
        orderUser.setExpressID( expressID );
        orderUser.setTakeCode( takeCode );
        orderUser.setHarvestName( harvestName );
        orderUser.setHarvestTelephone( harvestTelephone );
        orderUser.setPlace( place );
        orderUser.setRemarks( remarks );
        orderUser.setCreateUserID( createUserID );

        Integer i = orderUserService.creatUserOrder( orderUser );

        if(i!=1){
            //代表创建订单失败
            return MessageUtil.messageAuto( 400,"创建订单失败",null );
        }else {
            return MessageUtil.messageAuto( 200,"创建订单成功",null );
        }

    }

    /**
     * 删除订单的方法
     * @param userID
     * @return
     */
    @PostMapping("/deleteOrder")
    public Message deleteOrder(
            @RequestParam(name = "userID" ,required = true) String userID,
            @RequestParam(name = "orderID" ,required = true) String orderID
    ){
        //先查询redis中是否存在用户信息和订单信息
        String o = (String) redisTemplate.opsForValue().get( "user"+userID );


        return null;
    }
}
