package com.example.demo.mapping;

import com.example.demo.domain.SystemSwap;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ISystemMapping {

    /**
     * 查找所有的轮播图
     * @return
     */
    List<SystemSwap> findAllSystemSwap();
}
