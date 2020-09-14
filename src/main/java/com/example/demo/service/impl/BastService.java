package com.example.demo.service.impl;

import com.example.demo.mapping.IOrderMapping;
import com.example.demo.mapping.IShopMapping;
import com.example.demo.mapping.ISystemMapping;
import com.example.demo.mapping.IUserMapping;
import com.example.demo.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.sound.midi.VoiceStatus;

/**
 * 业务类的基类
 */
@Service
public class BastService {

    @Autowired
    protected ISystemMapping systemMapping;

    @Autowired
    protected IShopMapping shopMapping;

    @Autowired
    protected IOrderMapping orderMapping;

    @Autowired
    protected IUserMapping userMapping;

    @Autowired
    protected RedisTemplate redisTemplate;
}
