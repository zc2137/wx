package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private Long id;

    private String userID;     //用户的ID

    //用户名
    private String username;

    //用户电话
    private String telephone;

    //用户的积分
    private String userInteger;


}
