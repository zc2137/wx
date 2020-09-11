package com.example.demo.service.impl;

import com.example.demo.domain.SystemSwap;
import com.example.demo.service.ISystemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemServiceImpl extends BastService implements ISystemService{
    @Override
    public List<SystemSwap> findAllSwap() {

        return systemMapping.findAllSystemSwap();
    }
}
