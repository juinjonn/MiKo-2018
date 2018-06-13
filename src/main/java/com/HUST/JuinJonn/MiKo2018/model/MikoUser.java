package com.HUST.JuinJonn.MiKo2018.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class MikoUser {
    private Integer id;
    private String userAccountNumber;
    private String userPassWord;
    private String cipherText;
    private String publicText;
    private Integer userBalance;
    private Date createTime;
    private Date updateTime;
    private boolean isAdmin;
}
