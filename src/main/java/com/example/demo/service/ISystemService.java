package com.example.demo.service;

import com.example.demo.domain.SystemSwap;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ISystemService {

    /**
     * 查找首页的轮播图
     * @return
     */
    List<SystemSwap> findAllSwap();
}
