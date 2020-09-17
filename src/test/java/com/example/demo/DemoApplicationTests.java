package com.example.demo;

import com.example.demo.domain.User;
import com.example.demo.util.CheckAdminPassword;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.relational.core.sql.In;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;


    @Resource
    private StringRedisTemplate stringRedisTemplate;


    @Test
    void contextLoads() {
        User u = new User();
        u.setId( 1l );
        u.setTelephone( "125522323" );
        u.setUsername( "haha" );
        redisTemplate.opsForList().leftPush( "2",u );
        redisTemplate.opsForList().leftPush( "2",u );
        redisTemplate.opsForList().leftPush( "2",u );
        redisTemplate.opsForList().leftPush( "2",u );

        List<Object> users = redisTemplate.opsForList().range( "2",0,-1 );
        System.out.println(users);
    }

    @Test
    void test(){
       // redisTemplate.opsForValue().set( "haha" ,"1111");
        System.out.println(CheckAdminPassword.checkAP( redisTemplate,"a","a" ));
    }

    @Test
    void testRedis(){
        Boolean haha = redisTemplate.delete( "haha" );
        System.out.println(haha);
    }
}
