package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户地址的实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAddress {

    private Long id;

    private String address;
}
