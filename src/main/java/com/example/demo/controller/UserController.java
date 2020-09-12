package com.example.demo.controller;


import com.example.demo.domain.Message;
import com.example.demo.domain.Staff;
import com.example.demo.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserController extends BastController {

    /**
     * 外送员的登录方法
     * @return
     */
    @PostMapping("/staffLogin")
    public Message staffLogin(@RequestParam(name = "username" ,required = true) String username,
                              @RequestParam(name = "password" ,required = true) String password){

        Message m = new Message();
        Staff staff = userService.staffLogin( username, password );
        if(staff != null){
            //如果数据不为空
            return MessageUtil.messageAuto( 200,"success",staff );
        }else {
            return MessageUtil.messageAuto( 500,"登录失败，用户名或密码错误",null );
        }
    }

}
