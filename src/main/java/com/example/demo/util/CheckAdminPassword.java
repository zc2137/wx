package com.example.demo.util;

import org.springframework.data.redis.core.RedisTemplate;

public final class CheckAdminPassword {

    public static final boolean checkAP(RedisTemplate<String,Object> redisTemplate,
                                     String username, String password){
        String PS =(String) redisTemplate.opsForValue().get( username );
        if(password != null && password.equals( PS )){
            return true;
        }else {
            return false;
        }
    }
}
