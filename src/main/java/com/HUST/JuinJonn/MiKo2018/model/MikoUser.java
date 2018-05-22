package com.HUST.JuinJonn.MiKo2018.model;

import lombok.Data;

import java.util.Date;

@Data
public class MikoUser {
private Integer id;
private String userAccountNumber;
private String userPassWord;
private String ciphertext;
private Integer userBalance;
private Date createTime;
private Date updateTime;
private boolean isAdmin;
}
