package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;

    //用户名
    private String username;

    //用户电话
    private String telephone;

    //用户的积分
    private String userInteger;


}
